package com.example.mhis;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DatasAdapter extends RecyclerView.Adapter<DatasAdapter.DatasViewHolder>
{
    private Context mCtx;
    private List<UserData> userDataList;

    public DatasAdapter(Context mCtx, List<UserData> userDataList)
    {
        this.mCtx = mCtx;
        this.userDataList = userDataList;
    }

    @Override
    public DatasViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.datas_list, null);
        return new DatasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DatasViewHolder holder, int position)
    {
        UserData useraData = userDataList.get(position);

        holder.textViewTaj.setText(useraData.getTaj());
        holder.textViewUsername.setText(useraData.getUsername());
        holder.textViewPname.setText(String.valueOf(useraData.getP_name()));
        holder.textViewPaddress.setText(String.valueOf(useraData.getP_address()));
        holder.textViewPbirthday.setText(String.valueOf(useraData.getP_birthday()));
        holder.textViewPbirthplace.setText(String.valueOf(useraData.getP_birthplace()));
        holder.textViewPpassword.setText(String.valueOf(useraData.getP_password()));
        holder.textViewAllergy.setText(String.valueOf(useraData.getAllergy()));
        holder.textViewPemail.setText(String.valueOf(useraData.getP_email()));
    }

    @Override
    public int getItemCount() {
        return userDataList.size();
    }

    class DatasViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTaj, textViewUsername, textViewPname, textViewPaddress, textViewPbirthday, textViewPbirthplace, textViewPpassword, textViewAllergy, textViewPemail;

        public DatasViewHolder(View itemView) {
            super(itemView);

            textViewTaj = itemView.findViewById(R.id.textViewTaj);
            textViewUsername = itemView.findViewById(R.id.textViewUsername);
            textViewPname = itemView.findViewById(R.id.textViewPname);
            textViewPaddress = itemView.findViewById(R.id.textViewPaddress);
            textViewPbirthday = itemView.findViewById(R.id.textViewPbirthday);
            textViewPbirthplace = itemView.findViewById(R.id.textViewPbirthplace);
            textViewPpassword = itemView.findViewById(R.id.textViewPassword);
            textViewAllergy = itemView.findViewById(R.id.textViewAllergy);
            textViewPemail = itemView.findViewById(R.id.textViewPEmail);
        }
    }
}
