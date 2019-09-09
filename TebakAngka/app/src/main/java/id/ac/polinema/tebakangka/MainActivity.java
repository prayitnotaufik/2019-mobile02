package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini
	private int angkaInput,angkaRandom;
	private Random random;
	private EditText InputForm;
	private Button TebakBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO: bind layout di sini
		InputForm = findViewById(R.id.number_input);
		TebakBtn = findViewById(R.id.guess_button);
		random = new Random();
		initRandomNumber();
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {
		angkaRandom = random.nextInt(100)+1;

	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
		String numInputStr = InputForm.getText().toString();
		if(numInputStr.equalsIgnoreCase("")){
			Toast.makeText(this,"Input harus angka", Toast.LENGTH_SHORT).show();
		}else {
			angkaInput = Integer.parseInt(numInputStr);
			if (angkaInput > angkaRandom){
				Toast.makeText(this,"Angka terlalu besar", Toast.LENGTH_SHORT).show();
			} else if(angkaInput < angkaRandom){
				Toast.makeText(this,"Angka terlalu kecil",Toast.LENGTH_SHORT).show();
			} else if(angkaInput == angkaRandom){
				Toast.makeText(this,"Tebakan anda benar !",Toast.LENGTH_SHORT).show();
				TebakBtn.setEnabled(false);
			}
		}
	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
		InputForm.setText("");
		initRandomNumber();
		TebakBtn.setEnabled(true);
	}
}
