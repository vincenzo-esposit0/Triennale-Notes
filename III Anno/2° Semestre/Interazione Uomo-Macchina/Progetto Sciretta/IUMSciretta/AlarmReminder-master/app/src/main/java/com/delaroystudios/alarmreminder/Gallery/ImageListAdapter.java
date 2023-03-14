package com.delaroystudios.alarmreminder.Gallery;



import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.delaroystudios.alarmreminder.R;

import java.util.ArrayList;


/**
 * Created by franc on 13/02/2018.
 */


public class ImageListAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<Image> imageList;

    public ImageListAdapter(Context context, int layout, ArrayList<Image> imageList) {
        this.context = context;
        this.layout = layout;
        this.imageList = imageList;
    }



    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public Object getItem(int position) {
        return imageList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView txtName, txtAnno;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtName = (TextView) row.findViewById(R.id.txtName);
            holder.txtAnno = (TextView) row.findViewById(R.id.txtAnno);
            holder.imageView = (ImageView) row.findViewById(R.id.imgImage);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        Image image = imageList.get(position);

        holder.txtName.setText(image.getName());
        holder.txtAnno.setText(image.getAnno());

        byte[] picImage = image.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(picImage, 0, picImage.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;
    }
}
