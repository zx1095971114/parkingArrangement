package test;
import allInerface.*;
import dataBase.DataBaseImplement;

public class Test {

	public static void main(String[] args) {
		DataBase db = new DataBaseImplement();
		boolean b;
//		b = db.add_update_delete("insert into status values('湘A66666','2021-09-01','20:55:32','2021-09-05','06:07:01')");
//		b = db.add_update_delete("delete from status where car_id = '湘A88888'");
		b = db.add_update_delete("update status set car_id = '湘H68866' where car_id = '湘H88888'");
		System.out.println(b);
	}

}
