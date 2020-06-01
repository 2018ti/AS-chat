package cn.com.lenew.bluetooth.adapter;


import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import cn.com.lenew.bluetooth.R;


/**
 * Created by lenovo on 2016/7/3 0003.
 */
public class DevicesAdapter extends BaseAdapter {

    private ArrayList<BluetoothDevice> list;
    private Context mContext;

    public DevicesAdapter(Context context, ArrayList<BluetoothDevice> list){
        mContext = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView==null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.layout_device_list,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();

        BluetoothDevice device = list.get(position);
        viewHolder.name.setText(device.getName()+"");
        viewHolder.mac_tv.setText(device.getAddress()+"");

        return convertView;
    }


    public class ViewHolder{
        private TextView name;
        private TextView mac_tv;
        public ViewHolder(View view){
            name = (TextView) view.findViewById(R.id.device_name);
            mac_tv = (TextView) view.findViewById(R.id.device_mac);
        }
    }

    public void setList(ArrayList<BluetoothDevice> list) {
        this.list = list;
        if(list!=null){
            notifyDataSetChanged();
        }
    }
}

