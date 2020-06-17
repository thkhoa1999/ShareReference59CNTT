package vn.edu.ntu.truonghoangkhoa.sharereference59cntt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    public static final String tenSharePref = "my_share_pref";
    public static final String keyTen = "ten";
    public static final String keyNgaySinh = "ngay_sinh";
    public static final String keyNam = "nam";
    public static final String keyNu = "nu";
    public static final String keySDT = "sdt";
EditText edtTen,edtNgaySinh,edtSDT;
RadioButton rdbNam,rdbNu;
Button btnLuu,btnDoc,btnXoa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        docPref();
    }

    private void addView()
    {
        edtTen = findViewById(R.id.editTen);
        edtNgaySinh = findViewById(R.id.editNgaySinh);
        edtSDT = findViewById(R.id.edtSDT);
        rdbNam = findViewById(R.id.rdbNam);
        rdbNu = findViewById(R.id.rdbNu);
        btnLuu = findViewById(R.id.btnLuu);
        btnDoc = findViewById(R.id.btnDoc);
        btnXoa = findViewById(R.id.btnXoa);
        btnLuu.setOnClickListener(this);
        btnDoc.setOnClickListener(this);
        btnXoa.setOnClickListener(this);



    }

    @Override
    public void onClick(View v)
    {
        int id = v.getId();
        switch (id)
        {
            case R.id.btnLuu: luuPref();break;
            case R.id.btnDoc: docPref();break;
            case R.id.btnXoa: xoaThongTin();break;

        }

    }
    private void luuPref()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(tenSharePref,MODE_PRIVATE);
        if (sharedPreferences != null)
        {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(keyTen,edtTen.getText().toString());
            editor.putString(keyNgaySinh,edtNgaySinh.getText().toString());
            editor.putBoolean(keyNam,rdbNam.isChecked());
            editor.putBoolean(keyNu,rdbNu.isChecked());
            editor.putString(keySDT,edtSDT.getText().toString());
            editor.commit();
        }
    }
    private void docPref()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(tenSharePref,MODE_PRIVATE);
        if (sharedPreferences != null)
        {
          String ten = sharedPreferences.getString(keyTen, "Chưa có tên");
          String ngaysinh = sharedPreferences.getString(keyNgaySinh, "Chưa sinh ra");
          Boolean nam = sharedPreferences.getBoolean(keyNam, true);
          Boolean nu = sharedPreferences.getBoolean(keyNu, false);
          String sdt = sharedPreferences.getString(keySDT, "Chưa mua điện thoại");
          edtTen.setText(ten);
          edtNgaySinh.setText(ngaysinh);
          rdbNam.setChecked(nam);
          rdbNu.setChecked(nu);
          edtSDT.setText(sdt);

        }

    }
    private void xoaThongTin()
    {
        edtTen.setText("");
        edtNgaySinh.setText("");
        rdbNam.setChecked(true);
        rdbNu.setChecked(false);
        edtSDT.setText("");
    }
}
