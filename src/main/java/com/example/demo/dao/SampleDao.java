package com.example.demo.dao;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EntForm;

@Repository
public class SampleDao {

	private final JdbcTemplate db;

	@Autowired
	public SampleDao(JdbcTemplate db) {
		this.db = db;
	}
	public void insertDb(EntForm entform) {

		db.update("INSERT INTO sample (name,place,syoumikigen) VALUES(?,?,?)", entform.getName(),entform.getPlace(),entform.getSyoumkigen());
		
	}//public List<EntForm> searchDb(){
//
//	    try {
//	        db.update("INSERT INTO sample(name,place) VALUES(?, ?)", entform.getName(), entform.getPlace());
//	    } catch (Exception e) {
//	        e.printStackTrace(); // 例外を標準エラー出力に出力
//	    }
//	}

//	public void insertDb(EntForm entform) {
//		db.update("INSERT INTO * VALUES(?,?)", entform.getName(),entform.getPlace());
//		
//	}
//	
	public List<EntForm> searchDb4(){

		String sql = "SELECT * FROM sample";

		//データベースから取り出したデータをresultDB1に入れる
		List<Map<String, Object>> resultDb1 = db.queryForList(sql);

		//画面に表示しやすい形のList(resultDB2)を用意
		List<EntForm> resultDb2 = new ArrayList<EntForm>();

		//1件ずつピックアップ
		for(Map<String,Object> result1:resultDb1) {

			//データ1件分を1つのまとまりとしたEntForm型の「entformdb」を生成
			EntForm entformdb = new EntForm();

			//id、nameのデータをentformdbに移す
			entformdb.setId((int)result1.get("id"));
			entformdb.setName((String)result1.get("name"));
			entformdb.setSyoumkigen((Date)result1.get("syoumkigen"));
			//移し替えたデータを持ったentformdbを、resultDB2に入れる
			resultDb2.add(entformdb);
		}
		return resultDb2;
	}
	
	public List<EntForm> searchDb(){

		String sql = "SELECT * FROM sample where place='top'";

		//データベースから取り出したデータをresultDB1に入れる
		List<Map<String, Object>> resultDb1 = db.queryForList(sql);

		//画面に表示しやすい形のList(resultDB2)を用意
		List<EntForm> resultDb2 = new ArrayList<EntForm>();

		//1件ずつピックアップ
		for(Map<String,Object> result1:resultDb1) {

			//データ1件分を1つのまとまりとしたEntForm型の「entformdb」を生成
			EntForm entformdb = new EntForm();

			//id、nameのデータをentformdbに移す
			entformdb.setId((int)result1.get("id"));
			entformdb.setName((String)result1.get("name"));
			entformdb.setPlace((String)result1.get("place"));
			entformdb.setSyoumkigen((Date)result1.get("syoumkigen"));
			//移し替えたデータを持ったentformdbを、resultDB2に入れる
			resultDb2.add(entformdb);
		}

		//Controllerに渡す
		return resultDb2;
	}
	
	public List<EntForm> searchDb2(){

		String sql = "SELECT * FROM sample where place='middle'";

		//データベースから取り出したデータをresultDB1に入れる
		List<Map<String, Object>> resultDb1 = db.queryForList(sql);

		//画面に表示しやすい形のList(resultDB2)を用意
		List<EntForm> resultDb2 = new ArrayList<EntForm>();

		//1件ずつピックアップ
		for(Map<String,Object> result1:resultDb1) {

			//データ1件分を1つのまとまりとしたEntForm型の「entformdb」を生成
			EntForm entformdb = new EntForm();

			//id、nameのデータをentformdbに移す
			entformdb.setId((int)result1.get("id"));
			entformdb.setName((String)result1.get("name"));
			entformdb.setPlace((String)result1.get("place"));
			entformdb.setSyoumkigen((Date)result1.get("syoumkigen"));
			//移し替えたデータを持ったentformdbを、resultDB2に入れる
			resultDb2.add(entformdb);
		}

		//Controllerに渡す
		return resultDb2;
	}
	
	public List<EntForm> searchDb3(){

		String sql = "SELECT * FROM sample where place='bottom'";

		//データベースから取り出したデータをresultDB1に入れる
		List<Map<String, Object>> resultDb1 = db.queryForList(sql);

		//画面に表示しやすい形のList(resultDB2)を用意
		List<EntForm> resultDb2 = new ArrayList<EntForm>();

		//1件ずつピックアップ
		for(Map<String,Object> result1:resultDb1) {

			//データ1件分を1つのまとまりとしたEntForm型の「entformdb」を生成
			EntForm entformdb = new EntForm();

			//id、nameのデータをentformdbに移す
			entformdb.setId((int)result1.get("id"));
			entformdb.setName((String)result1.get("name"));
			entformdb.setPlace((String)result1.get("place"));
			entformdb.setSyoumkigen((Date)result1.get("syoumkigen"));
			//移し替えたデータを持ったentformdbを、resultDB2に入れる
			resultDb2.add(entformdb);
		}

		//Controllerに渡す
		return resultDb2;
	}
	
	
		//更新画面の表示(SELECT)
		public List<EntForm> selectOne(Long id) {

			//コンソールに表示
			System.out.println("編集画面を出します");
			//データベースから目的の1件を取り出して、そのままresultDB1に入れる
			List<Map<String, Object>> resultDb1 = db.queryForList("SELECT * FROM sample where id=?", id);
			//画面に表示しやすい形のList(resultDB2)を用意
			List<EntForm> resultDb2=new ArrayList<EntForm>();

			//1件ずつピックアップ
			for(Map<String,Object> result1:resultDb1) {
				//データ1件分を1つのまとまりとするので、EntForm型の「entformdb」を生成
				EntForm entformdb = new EntForm();
				//id、nameのデータをentformdbに移す
				entformdb.setId((int)result1.get("id"));
				entformdb.setName((String)result1.get("name"));
				//移し替えたデータを持ったentformdbを、resultDB2に入れる
				resultDb2.add(entformdb);
			}

			//Controllerに渡す
			return resultDb2;
		}
		
		//削除(DELETE)
				public void deleteDb(Long id) {
					//コンソールに表示
					System.out.println("削除しました");
					//DBからデータを削除
					db.update("delete from sample where id=?", id);
				}
		
		//更新の実行(UPDATE)
		public void updateDb(Long id, EntForm entform) {
			//コンソールに表示
			System.out.println("編集の実行");
			//UPDATEを実行
			db.update("UPDATE sample SET name = ? WHERE id = ?",entform.getName(), id);
		}
	
	
}
