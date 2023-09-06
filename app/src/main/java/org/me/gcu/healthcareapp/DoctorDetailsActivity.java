package org.me.gcu.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String [][] doctor_details1 =
            {
                    {"Doctor Name: Jonathan Rennie", "Hospital Address: Weymouth Crescent", "Experience: 5 years", "Mobile Number: 07843893451", "600"},
                    {"Doctor Name: Scott Keogh", "Hospital Address: Binnie Street", "Experience: 10 years", "Mobile Number: 07920323876", "900"},
                    {"Doctor Name: Davide Moretti", "Hospital Address: Oxford Avenue", "Experience: 20 years", "Mobile Number: 07992309411", "300"},
                    {"Doctor Name: David Ellis", "Hospital Address: Cardwell Bay", "Experience: 8 years", "Mobile Number: 07263782929", "500"},
                    {"Doctor Name: Creag Little", "Hospital Address: Weirs Wynd", "Experience: 3 years", "Mobile Number: 07293939213", "800"},
            };

    private String [][] doctor_details2 =
            {
                    {"Doctor Name: Jack Millar", "Hospital Address: Midton ", "Experience: 29 years", "Mobile Number: 08393828304", "600"},
                    {"Doctor Name: Steward Sinclair", "Hospital Address: Port Glasgow", "Experience: 12 years", "Mobile Number: 08928923876", "900"},
                    {"Doctor Name: Mikey Mckitrick", "Hospital Address: Gourock", "Experience: 3 years", "Mobile Number: 08002302411", "300"},
                    {"Doctor Name: Brendan Reddy", "Hospital Address: Glamis Place", "Experience: 5 years", "Mobile Number: 08263732921", "500"},
                    {"Doctor Name: Emily Murdoch", "Hospital Address: Divert Road", "Experience: 20 years", "Mobile Number: 08243934202", "800"},
            };

    private String [][] doctor_details3 =
            {
                    {"Doctor Name: Ryan Bryceland", "Hospital Address: Greenock", "Experience: 9 years", "Mobile Number: 09843893451", "600"},
                    {"Doctor Name: Andrew Mccalister", "Hospital Address: Notre Damn", "Experience: 10 years", "Mobile Number: 099204563876", "900"},
                    {"Doctor Name: Anthony Doherty", "Hospital Address: Grieve Road", "Experience: 40 years", "Mobile Number: 09212309421", "300"},
                    {"Doctor Name: Tom Ford", "Hospital Address: Gourock", "Experience: 8 years", "Mobile Number: 09263782929", "500"},
                    {"Doctor Name: Creag Little", "Hospital Address: Weirs Wynd", "Experience: 3 years", "Mobile Number: 08293939208", "800"},
            };

    private String [][] doctor_details4 =
            {
                    {"Doctor Name: Jenifer Coyle", "Hospital Address: Larkfield", "Experience: 9 years", "Mobile Number: 01843893451", "600"},
                    {"Doctor Name: Lauryn Mclees", "Hospital Address: Lyndoch", "Experience: 19 years", "Mobile Number: 01520323876", "900"},
                    {"Doctor Name: Niall Skelton", "Hospital Address: Edinburgh", "Experience: 23 years", "Mobile Number: 019492305640", "300"},
                    {"Doctor Name: Marc Fortune", "Hospital Address: Darvel", "Experience: 35 years", "Mobile Number: 01263782929", "500"},
                    {"Doctor Name: Roy Jones", "Hospital Address: Wanderers", "Experience: 5 years", "Mobile Number: 01293539102", "800"},
            };

    private String [][] doctor_details5 =
            {
                    {"Doctor Name: Shunsuke Nakamura", "Hospital Address: Tokyo", "Experience: 20 years", "Mobile Number: 03843893476", "600"},
                    {"Doctor Name: James Forrest", "Hospital Address: Fleetwood", "Experience: 4 years", "Mobile Number: 03920523814", "900"},
                    {"Doctor Name: Hugh Keevins", "Hospital Address: Clyde", "Experience: 50 years", "Mobile Number: 039923094467", "300"},
                    {"Doctor Name: David Knight", "Hospital Address: Broomhill", "Experience: 11 years", "Mobile Number: 03263782634", "500"},
                    {"Doctor Name: Simon Ferry", "Hospital Address: BarrHead", "Experience: 3 years", "Mobile Number: 03456293749", "800"},
            };


    TextView tv;
    Button btn;
    ArrayList list;

    SimpleAdapter sa;
    HashMap <String, String> item;
    String[][] doctor_details = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonLTBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Family Physicians") == 0)
            doctor_details = doctor_details1;
        else if (title.compareTo("Dietitian") == 0)
            doctor_details = doctor_details2;
        else if (title.compareTo("Dentist") == 0)
            doctor_details = doctor_details3;
        else if (title.compareTo("Surgeon") == 0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for (int i = 0; i < doctor_details.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons Fees:" + doctor_details[i][4] + "/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e,}
        );

        ListView lst = findViewById(R.id.listViewLT);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1", title);
                it.putExtra("text2", doctor_details[i][0]);
                it.putExtra("text3", doctor_details[i][1]);
                it.putExtra("text4", doctor_details[i][3]);
                it.putExtra("text5", doctor_details[i][4]);
                startActivity(it);
            }
        });



    }
}