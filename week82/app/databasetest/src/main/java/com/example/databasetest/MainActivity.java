package com.example.databasetest;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity {

    List<book> bookList;
    List<Category> CategoryList;
    MyDatabaseHelper myDatabaseHelper;
    SQLiteDatabase db;
    MyAdapter myAdapter;
    private Object categoryname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lv = (ListView) findViewById(R.id.book_listview);
        bookList = new ArrayList<book>();
        myDatabaseHelper = new MyDatabaseHelper(this);
        // 得到数据库
        db = myDatabaseHelper.getWritableDatabase();
        // 插入数据
        Insert();
        // 查询数据
        Query();
        // 创建MyAdapter实例
        myAdapter = new MyAdapter(this);
        // 向listview中添加Adapter
        lv.setAdapter(myAdapter);
    }

    // 创建MyAdapter继承BaseAdapter
    class MyAdapter extends BaseAdapter {
        private Context context;
        private LayoutInflater inflater;

        public MyAdapter(Context context) {
            this.context = context;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return bookList.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // 从personList取出Person
            book b = bookList.get(position);
            Category c=CategoryList.get(position);
            ViewHolder viewHolder = null;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = inflater.inflate(R.layout.listitem_layout, null);
                viewHolder.txt_name = (TextView) convertView.findViewById(R.id.book_name);
                viewHolder.txt_code = (TextView) convertView.findViewById(R.id.book_categoryname);
                viewHolder.txt_price = (TextView) convertView.findViewById(R.id.book_price);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            //向TextView中插入数据
            viewHolder.txt_code.setText(c.getCategoryname());
            viewHolder.txt_name.setText(b.getName());
            viewHolder.txt_price.setText(b.getPrice());

            return convertView;
        }
    }

    class ViewHolder {
        private TextView txt_code;
        private TextView txt_name;
        private TextView txt_price;
    }

    // 插入数据
    public void Insert() {
            ContentValues values = new ContentValues();
            values.put("name", "西游记" );
            values.put("price", "34");
            values.put("categoryname", "文学类");
            db.insert("book", null, values);
        db.insert("Category", null, values);
    }

    // 查询数据
    public void Query() {
        Cursor cursor = db.query("book", null, null, null, null, null, null);
        Cursor cursor1 = db.query("Category", null, null, null, null, null, null);
        while (cursor.moveToNext()&&cursor1.moveToNext()) {
            String name = cursor.getString(0);
            String price = cursor.getString(1);
            book book = new book(name, price);
            String code=cursor1.getString(2);
            Category category=new Category(categoryname);
            bookList.add(book);
            CategoryList.add(category);
        }
    }

}