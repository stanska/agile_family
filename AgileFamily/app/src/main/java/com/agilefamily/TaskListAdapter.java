package  com.agilefamily;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.agilefamily.service.TaskService;


public class TaskListAdapter extends BaseAdapter {
    private Context mContext;
    private TaskService taskService;
    public TaskListAdapter(Context c) {
        mContext = c;
        taskService = new TaskService();
    }

    public int getCount() {
        return taskService.getTasks().length;
    }

    //Todo - pass tasks to view, not call getTask any time

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            view = new View(mContext);

            view = inflater.inflate(R.layout.grid_single, null);
            view.setLayoutParams(new GridView.LayoutParams(320, 320));
            TextView textView = (TextView) view.findViewById(R.id.grid_text);
            textView.setText(taskService.getTasks()[position].name);
            ImageView imageView = (ImageView)view.findViewById(R.id.grid_single_owner);
            imageView.setImageResource(mThumbIds[position%6]);
            if ( position % 4 == 0) {
                view.setBackgroundColor(ContextCompat.getColor(mContext, R.color.motherColor));
            } else if ( position % 4 == 1) {
                view.setBackgroundColor( ContextCompat.getColor(mContext, R.color.colorAccent));
            }  else if ( position % 4 == 2) {
                view.setBackgroundColor( ContextCompat.getColor(mContext, R.color.colorPrimaryDark));
            }  else if ( position % 4 == 3) {
                view.setBackgroundColor(Color.YELLOW);
            }

            ImageView imageViewStatus = (ImageView)view.findViewById(R.id.grid_single_status);
            imageViewStatus.setImageResource(statusImages[position%4]);


//        textView.setImageResource(mThumbIds[position]);
//            textView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            textView.setPadding(4, 4, 4, 4);
        } else {
            view = (View) convertView;
        }

        return view;
    }

//    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7
    };

    private Integer[] statusImages = {
            R.drawable.done1,
            R.drawable.overdue1,
            R.drawable.reminder1,R.drawable.in_progress1
    };
}