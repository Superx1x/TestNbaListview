package com.example.testnbalistview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public abstract class MyBaseAdapter<T> extends BaseAdapter{

	protected Context context;
	protected ArrayList<T> dataList;
	public void setDataList(ArrayList<T> dataList) {
		this.dataList = dataList;
		//notifyDataSetChanged();
	}//setter

	protected LayoutInflater inflater;
	protected abstract void rowSelected(T song, int index);

	public MyBaseAdapter(Context context, ArrayList<T> dataList) {
		super();
		this.context = context;
		this.inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.dataList = dataList;
	}//建構子

	@Override
	public int getCount() {
		return dataList.size();
	}//BaseAdapter擴充1

	@Override
	public T getItem(int position) {
		return dataList.get(position);
	}//BaseAdapter擴充2

	@Override
	public long getItemId(int position) {
		return position;
	}//BaseAdapter擴充3

//	@Override
//	public View getView(int position, View convertView, ViewGroup parent) {
//		return null;
//	}//BaseAdapter擴充4，但老師留到我們的再繼承去實作

	public ArrayList<T> getDataList() {
		return dataList;
	}//getter

	

}
