package com.agilefamily;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.Toast;

import com.agilefamily.domain.Task;
import com.agilefamily.service.TaskService;

import java.util.Arrays;

public class NewTaskDialog extends DialogFragment {
    private TaskListAdapter taskListAdapter;

    public void setTaskListAdapter(TaskListAdapter taskListAdapter) {
        this.taskListAdapter = taskListAdapter;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(R.layout.new_task_dialog);
        builder.setPositiveButton(R.string.create, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                TaskService taskService = new TaskService();
                EditText edit= (EditText) getDialog().findViewById(R.id.new_task_name);
                System.out.println(edit.getText().toString());
                taskService.newTask(new Task(edit.getText().toString(), null, null));
                System.out.println(Arrays.toString(taskService.getTasks()));
                taskListAdapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        return builder.create();
    }
}