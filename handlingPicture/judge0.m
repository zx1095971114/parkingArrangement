function judge
SamplePath1 ='C:\handlingPicture';
cd(SamplePath1);
file="2.jpg";
Img_rgb=imread(file);  
Gray_Img=rgb2gray(Img_rgb);
Img_gray = imadjust(Gray_Img, [], [0.25, 0.75], 2);       %灰度图增强
Img_gray = histeq(Img_gray);                          %直方图均衡
%figure(1),subplot(1,3,1),imshow(Img_rgb),title('原始图像');
%subplot(1,3,2),imshow(Img_gray),title('灰度图增强后的图像');
%subplot(1,3,3),imhist(Img_gray), title('灰度图增强后的直方图');
% pictureGray1 = rgb2gray(Img_rgb);
%  %水平方向调整
%     T=affine2d([0 1 0;1 0 0;0 0 1]);
%     pictureTr=imwarp(pictureGray1,T); 
%     theta = -20 : 20;                 
%     r1 = radon(pictureTr, theta);     
%     result1 = sum(abs(diff(r1)), 1);  %     rot1 = find(result1==max(result1))-21;
%     pictureRo = imrotate(Img_rgb, rot1);
%     figure, imshow(Img_rgb), title('调整之前');
%     figure, imshow(pictureRo), title('调整水平角度之后的图像');
%    % 竖直方向调整
%     pictureGray2 = rgb2gray(pictureRo);
%     r2 = radon(pictureGray2, theta);
%     result2 = sum(abs(diff(r2)), 1);
%     rot2 = (find(result2==max(result2))-21)/57.3;           %将数值转为角度
%     if rot2>0
%         T1 = affine2d([1 0 0 ; -tan(rot2) 1 0 ; size(pictureGray2, 1) * tan(rot2) 0 1]);
%     else
%         T1 = affine2d([1 0 0 ; tan(-rot2) 1 0 ; size(pictureGray2, 1) * tan(-rot2) 0 1]);
%     end
%     Img_gray = imwarp(pictureRo, T1);
%     Img_gray=rgb2gray(Img_gray);
%     figure, imshow(Img_gray), title('水平+竖直调整之后的图像');

Img=edge(Gray_Img, 'sobel', 0.15, 'both');
%figure(2),subplot(2,3,1),imshow(Img),title('边缘检测后的图像');
% %均值滤波处理
% A=fspecial('average',3);      
% Img_filt=filter2(A,Img_gray)/255;
% Img_edge = edge(Img_filt, 'roberts', 0.09, 'vertical');
%图像腐蚀
s=[1;1;1];
Img_E=imerode(Img,s);
%闭处理
s=strel('rectangle',[25,25]);2
Img_close=imclose(Img_E, s);
Img_cd=bwareaopen(Img_close,2000);
pictureRe = regionprops(Img_cd, 'boundingbox');
%     areas = [pictureRe.Area];    %将面积对象保存到areas里
rects = cat(1, pictureRe.BoundingBox);      
%将面积对象的边界条件链接并保存到rects，顺序为[起始点x坐标, 起始点y坐标, 面积对象长度(x), 面积 对象宽度(y)]      
%subplot(2,3,3), imshow(Img_cd), title('红色框标记完之后的图像'); 
[num,twidth]=size(rects);
ti=1;
for i = 1:num
    if rects(i,3)/rects(i,4)>=2 && rects(i,3)/rects(i,4)<=5
        rectangle('position', rects(i, :), 'EdgeColor', 'r');   %定位车牌区域，并用红色的框标记
        ti=i;
    end
end
Gray_Img = imcrop(Img_rgb, rects(ti, :));                      %按照红线框切割车牌区域

%subplot(2,3,2), imshow(Img_E), title('腐蚀后的图像');
%subplot(2,3,4), imshow(Gray_Img), title('裁剪完之后的图像');
Img_hsv=rgb2hsv(Gray_Img);
[y,x,z]=size(Img_hsv);
PY1=1;
PY2=y;
PX1=1;
PX2=x;
flag=zeros(y,x);
for i = 1:y
    for j = 1:x
        %200-255 0.4-1 0.3-1
        if (Img_hsv(i,j,1)*360<=255) && (Img_hsv(i,j,1)*360>=200) && (Img_hsv(i,j,2)>=0.4) && (Img_hsv(i,j,2)<=1) && (Img_hsv(i,j,3)<=1) && (Img_hsv(i,j,3)>=0.3)
            flag(i,j)=1;
        end
    end
end
while PY1<=y
    if find(flag(PY1,:))
        break;
    end
    PY1=PY1+1;
end
while PY2>=1
    if find(flag(PY2,:))
        break;
    end
    PY2=PY2-1;
end
while PX1<=x
    if find(flag(:,PX1))
        break;
    end
    PX1=PX1+1;
end
while PX2>=1
    if find(flag(:,PX2))
        break;
    end
    PX2=PX2-1;
end
Gray_Img=Gray_Img(PY1+1:PY2-1,PX1+1:PX2-1,:);
%subplot(2,3,6), imshow(Gray_Img), title('hsv选择');
[PIN0,PIN1,PIN2,PIN3,PIN4,PIN5,PIN6] = zffg(Img_rgb, Gray_Img);
Default=zeros(1,44);
StringName=char(['0':'9' 'A':'H','J':'N', 'P':'Z' '京津沪豫鲁苏浙晋陕琼粤']);
Diffrent=zeros(40,20);
Number=zeros(1,14);
Lm=[35,11,1,1,1,1,1];
Rm=[45,34,34,34,34,34,34];
for T=1:7
    str_t=int2str(T-1);
    Num_Filename=strcat('分割结果\', str_t,'.jpg');
    t=imread(Num_Filename);
    My_Img=double(t)>20;
    L=Lm(T);
    R=Rm(T);
    Min_Default=inf;
    for Now_Count=L:R
        fname=strcat('字符模板\',StringName(Now_Count),'.jpg');
        Model_Img=imread(fname);
        Model_Img=double(Model_Img)>1;  % 转化为0-1矩阵
        Diffrent=My_Img-Model_Img;
        Default_Max=0;
        for i=1:40
            for j=1:20
                if Diffrent(i,j)~=0
                    Default_Max=Default_Max+1;
                end
            end
        end
        Default(Now_Count)=Default_Max;
        if Default_Max<Min_Default
            Min_Default=Default_Max;
            c=Now_Count;
        end
    end
    Last_Default=Default(L:R);
    Min_Default=min(Last_Default);
    Number(T)=StringName(c);
    
end
%figure(5),imshow(Img_rgb),title(['车牌号码：',Number],'Color','r');
fid=fopen('matlabtest.txt','wt');
fprintf(fid,'%s\n',Number);
close(figure(1));
function [PIN0,PIN1,PIN2,PIN3,PIN4,PIN5,PIN6] = zffg(I, Img_gray)
dw=Img_gray;%车牌定位
%figure(3);
%subplot(3,2,1),imshow(dw),title('定位剪切后车牌图像')
I1 = rgb2gray(dw);    %将RGB图像转化为灰度图像
%subplot(3,2,2),imshow(I1),title('车牌灰度图像')
g_max=double(max(max(I1)));
g_min=double(min(min(I1)));
T=round(g_max-(g_max-g_min)/3); % T 为二值化的阈值
[m,n]=size(I1);% d:二值图像
I1=imbinarize(I1,T/255);
%subplot(3,2,3);
%imshow(I1),title('二值化车牌图像');
I1=bwareaopen(I1,20);
%subplot(3,2,4);
%imshow(I1),title('删除无用点后的二值化图像');
[y1,x1,z1]=size(I1);
I3=double(I1);
TT=1;
%%%%%% 分割字符按行积累量%%%%%
X1=zeros(1,x1);
Y1=zeros(y1,1);
for j=1:x1
    for i=1:y1
             if(I3(i,j,1)==1) 
                X1(1,j)= X1(1,j)+1;
            end  
     end       
end
%figure(3);
Px0=1;
Px1=1;
Py0=1;
Py1=1;
%%%%%%%%%%%%分割字符%%%%%%%%%%%%%
for i=1:7
  while ((X1(1,Px0)<3)&&(Px0<x1))
      Px0=Px0+1;
  end
  Px1=Px0;
  while (((X1(1,Px1)>=3)&&(Px1<x1-1)) || Px1-Px0<10)
      Px1=Px1+1;
  end
  Z=I1(:,Px0:Px1,:);
  for j=1:Px1-Px0+1
      for ii=1:y1
          if(Z(ii,j,1)==1)
              Y1(ii,1)= Y1(ii,1)+1;
          end
      end
  end
  while ((Y1(Py0,1)<3)&&(Py0<y1))
      Py0=Py0+1;
  end
  Py1=y1;
  while (((Y1(Py1,1)<3)&&(Py1>1)))
      Py1=Py1-1;
  end
  Z=Z(Py0:Py1,:,:);
  Z=imresize(Z,[40,20], 'nearest');
  switch num2str(i)
      case '1'
          PIN0=Z;
      case '2'
          PIN1=Z;
      case '3'
          PIN2=Z;
      case '4'
          PIN3=Z;
      case '5'
          PIN4=Z;
      case '6'
          PIN5=Z;
      otherwise 
          PIN6=Z;
  end
  Px0=Px1;
end
imwrite(PIN0,'分割结果\0.jpg','jpg');
imwrite(PIN1,'分割结果\1.jpg','jpg');
imwrite(PIN2,'分割结果\2.jpg','jpg');
imwrite(PIN3,'分割结果\3.jpg','jpg');
imwrite(PIN4,'分割结果\4.jpg','jpg');
imwrite(PIN5,'分割结果\5.jpg','jpg');
imwrite(PIN6,'分割结果\6.jpg','jpg');
%figure(4)
%subplot(1,7,1);
%imshow(PIN0);
%subplot(1,7,2);
%imshow(PIN1);
%subplot(1,7,3);
%imshow(PIN2);
%subplot(1,7,4);
%imshow(PIN3);
%subplot(1,7,5);
%imshow(PIN4);
%subplot(1,7,6);
%imshow(PIN5);
%subplot(1,7,7);
%imshow(PIN6);

end
end
