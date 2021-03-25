package es.udc.psi.lab3touris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;

public class Peliculon extends GlobalActivity {

    @BindView(R.id.title) TextView TVtitle;
    @BindView(R.id.sub_title) TextView TVsubtitle;
    @BindView(R.id.description) TextView TVdescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculon);

        Intent intent = getIntent();
        String title = intent.getStringExtra("Titulon");
        String subtitle = intent.getStringExtra("SubTitulon");;
        String description = intent.getStringExtra("Descripcion");;
        TVtitle.setText(title);
        TVsubtitle.setText(subtitle);
        TVdescription.setText(description);
    }
}