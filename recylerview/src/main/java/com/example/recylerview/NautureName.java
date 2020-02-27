package com.example.recylerview;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class NautureName extends RecyclerView.Adapter<NautureName.NautureHolder> {
    public NautureName(Context context, List<AndroidVersion> list) {
        this.context = context;
        this.list = list;
    }

    private Context context;
    private List<AndroidVersion> list;
    private AlertDialog.Builder builder;
    private Activity activity;
    @NonNull
    @Override
    public NautureHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context)
                .inflate(R.layout.singke_view,parent,false);
        return new NautureHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final NautureHolder holder, final int position) {
       holder.getName().setText(list.get(position).getImage());
       holder.getImage().setImageResource(list.get(position).getImage());
       holder.getName().setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               builder=new AlertDialog.Builder(context);
                      //Uncomment the below code to Set the message and title from the strings.xml file
                   builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);

                   //Setting message manually and performing action on button click
                   builder.setMessage("Do you want to close this application ?");
                   builder.setCancelable(false);
                   builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                               public void onClick(DialogInterface dialog, int which) {
                                  activity.finish();
                                   Toast.makeText(context.getApplicationContext(),"you choose yes action for alertbox",
                                           Toast.LENGTH_SHORT).show();
                               }
                           });
               builder .setNegativeButton("No", new DialogInterface.OnClickListener() {
                               public void onClick(DialogInterface dialog, int id) {
                                   //  Action for 'NO' Button
                                   dialog.cancel();
                                   Toast.makeText(context.getApplicationContext(),"you choose no action for alertbox",
                                           Toast.LENGTH_SHORT).show();
                               }
                           });

               showDialog();


                   Toast.makeText(context, "position: " +position+ "Name :" +list.get(position).getName(),Toast.LENGTH_SHORT).show();
               Snackbar snackbar = Snackbar
                       .make(holder.getLayout(), "position", Snackbar.LENGTH_LONG);

               snackbar.show();
           }
       });



    }

    private void showDialog(){
        final Dialog dialog=new Dialog(context);
        dialog.setContentView(R.layout.dialougecustom);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);

        Button btnYes= dialog.findViewById(R.id.btnYes);
        Button btnNo=dialog.findViewById(R.id.btnNo);
        dialog.show();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class NautureHolder extends RecyclerView.ViewHolder {

        public NautureHolder(@NonNull View itemView) {
            super(itemView);
        }

        TextView getName(){
            return itemView.findViewById(R.id.textView11);

        }
        ImageView getImage(){
            return itemView.findViewById(R.id.imageView3);
        }
      ConstraintLayout getLayout(){
            return itemView.findViewById(R.id.singleCardConstraint);
      }
    }}

