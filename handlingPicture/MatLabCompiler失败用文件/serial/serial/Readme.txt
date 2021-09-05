Самый простой способ установить Матлаб это запустить "SetupSimple.exe"
При этом не надо закрывать программу "SetupSimple" до того как закончится установка Матлаба.
Когда вас попросят активировать программу ОТКАЖИТЕСЬ.

Если упрощенный способ не сработал придется проделать установку вручную по пунктам:
(для экономии времени можно попробовать сначала сделать только пункт 6 ... 
 если не помогло - то придется проделать все с пункта 1)

Всегда выбираем опцию без использования интернет "without using the internet"
Ниже "X:\" означает букву диска куда вы смонтировали iso-образ с установщиком Матлаба)

1) запустить "X:\setup.exe"
    ИЛИ 
   запустить "X:\bin\win32\setup.exe" (если хотите установить 32-битный Матлаб под 64-битной Виндовз)

2) выбрать "install manually without using the internet"		

3) когда спросят ввести "file installation key" ввести
    12313-94680-65562-90832

4) установить Матлаб (если хотите чтобы Матлаб занимал меньше места и был чуточку быстрее
    то выбирайте "Custom" установку и устанавливайте ТОЛЬКО требуемые в вашей работе компоненты)

5) когда вас попросит активировать можно ЛИБО отказаться от активации
    ЛИБО
   согласиться и выбрать способ активации без интернета и указать файл лицензии "X:\serial\license.lic"

6) скопировать папку "bin"
    из папки "X:\serial\MatlabX32" или "X:\serial\MatlabX64" (в зависимость от битности установленного Матлаба)
    в папку куда вы установили Матлаб  С ПЕРЕЗАПИСЬЮ  файлов 
    Это действие может потребовать от вас Административных прав (для Виндовз новее чем WinXP)  

Если вам нужно поставить серверные компоненты (т.е. вы понимаете что делаете) то в укажите на шаге 3:
  23809-31321-26556-08694
 



For English-speaking persons:

The simplest way to install Matlab is to run "SetupSimple.exe"
Do not close "SetupSimple" program until installation of Matlab is finished.
When you will be asked to activate the, program REFUSE to do so.

If simplified setup does not work for you just execute following steps manually:
(to save time try to execute STEP 6 ONLY ...  and if it did not helped - execute all steps from step 1)

(let the "X:\" be the letter of mounted Matlab iso-image)
1) run "X:\setup.exe"
    OR 
   run "X:\bin\win32\setup.exe" (if you want to install 32-bit Matlab under 64-bit Windows)

2) choose "install manually without using the internet"		

3) when you will be asked to enter the "file installation key" use
    12313-94680-65562-90832

4) setup Matlab (if you want Matlab to use less space and be little bit faster select "Custom" setup
    and select ONLY components required for you)

5) when you will be asked to activate the product you can refuse to activate
    OR
   select activation without internet and use "X:\serial\license.lic" as license file

6) copy folder "bin" and its content
    from folder "X:\serial\MatlabX32" or "X:\serial\MatlabX64" (depending on 32-bit or 64-bit you have installed)
    to folder where you installed Matlab  WITH OVERWRITING  of existing files
    This could ask you to use Administrative rights (for Windows newer then WinXP)  


If you need server components of Matlab (suppose you know what you are doing) then at step 3 use:
  23809-31321-26556-08694
