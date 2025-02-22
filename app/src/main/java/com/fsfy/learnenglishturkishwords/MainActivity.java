package com.fsfy.learnenglishturkishwords;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayoutSend, linearLayoutSolution;
    private EditText editTextAnswer;
    private TextView textViewWord, textViewCount, textViewSend, textViewAnswer, textViewSolution, textViewSelectedArray, textViewWordCount;
    private ImageView imageSettings;
    //    private Typeface typeface1, typeface2, typeface3;
    private Button buttonList;
    private CheckBox checkBoxSuffle, checkBoxTr_En;

    String answer, allListCount;
    private String[][] WordList;
    private ArrayList<String[][]> allList = new ArrayList<String[][]>();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        getSupportActionBar().hide();

        sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);

        allList.add(Words.Nesneler);
        allList.add(Words.Sifatlar);
        allList.add(Words.Fruit);
        allList.add(Words.Fiiller);
        allList.add(Words.Aileiliski);
        allList.add(Words.Meslekler);
        allList.add(Words.Yerler);
        allList.add(Words.Renkler);
        allList.add(Words.Hayvanlar);
        allList.add(Words.Vucut);
        allList.add(Words.Zaman);
        allListCount = String.valueOf(Words.Nesneler.length + Words.Sifatlar.length + Words.Fruit.length + Words.Fiiller.length + Words.Aileiliski.length + Words.Meslekler.length + Words.Yerler.length + Words.Renkler.length + Words.Hayvanlar.length + Words.Vucut.length + Words.Zaman.length);

        WordList = Words.Sifatlar;

        linearLayoutSend = (LinearLayout) findViewById(R.id.linearlayout_send);
        linearLayoutSolution = (LinearLayout) findViewById(R.id.linearlayout_solution);
        editTextAnswer = (EditText) findViewById(R.id.edittext_answer);
        textViewWord = (TextView) findViewById(R.id.textview_word);
        textViewCount = (TextView) findViewById(R.id.textview_count);
        textViewSend = (TextView) findViewById(R.id.textview_send);
        textViewAnswer = (TextView) findViewById(R.id.textview_answer);
        textViewSolution = (TextView) findViewById(R.id.textview_solution);
        textViewSelectedArray = (TextView) findViewById(R.id.textview_selectedarray);
        buttonList = (Button) findViewById(R.id.button_liste);
        checkBoxSuffle = (CheckBox) findViewById(R.id.checkbox_suffle);
        checkBoxTr_En = (CheckBox) findViewById(R.id.checkbox_tr_en);
        textViewWordCount = (TextView) findViewById(R.id.textview_wordcount);

        textViewWordCount.setText("1/" + String.valueOf(WordList.length));

        linearLayoutSolution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewAnswer.setText(answer);
            }
        });

        linearLayoutSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (String.valueOf(editTextAnswer.getText()).toLowerCase().equals(answer.toLowerCase()))
                    sorubulyaz();
            }
        });

        buttonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadListDialog();
            }
        });

        editTextAnswer.setImeOptions(EditorInfo.IME_ACTION_GO);
        editTextAnswer.setRawInputType(InputType.TYPE_CLASS_TEXT);
        editTextAnswer.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (String.valueOf(editTextAnswer.getText()).toLowerCase().equals(answer.toLowerCase())) {
                    //                    Toast.makeText(MainActivity.this, "Doğru!", Toast.LENGTH_SHORT).show();
                    sorubulyaz();
                } else {
                    //                    Toast.makeText(MainActivity.this, "Yanlış!", Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });

        textViewSelectedArray.setText("Nesneler".toUpperCase());
        textViewCount.setText(String.valueOf(WordList.length) + " kelime var!");
        sorubulyaz();

        ((TextView) findViewById(R.id.textView_check_rastgele)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBoxSuffle.isChecked()) checkBoxSuffle.setChecked(false);
                else checkBoxSuffle.setChecked(true);
            }
        });

        ((TextView) findViewById(R.id.textView_check_entr)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBoxTr_En.isChecked()) checkBoxTr_En.setChecked(false);
                else checkBoxTr_En.setChecked(true);
            }
        });

        imageSettings = (ImageView) findViewById(R.id.img_main_settings);
        imageSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout LinearKeyboard = (LinearLayout) findViewById(R.id.KEYBOARD);
                if (LinearKeyboard.getVisibility() == View.GONE) {
                    LinearKeyboard.setVisibility(View.VISIBLE);
                    editTextAnswer.setEnabled(false);
                } else if (LinearKeyboard.getVisibility() == View.VISIBLE) {
                    LinearKeyboard.setVisibility(View.GONE);
                    editTextAnswer.setEnabled(true);
                }
            }
        });

        CustomSettings.isVibration = true;
        CustomSettings.isSound = true;
        loadKeyboardKey();

        SoundAndVibrationCheck();
    }

    Integer lastNumNormal = 0 /* sıralı soruda kaçıncıda */, lastNumCount = 0 /*  */;
    ArrayList<Integer> AskList;

    @SuppressLint("SetTextI18n")
    public void sorubulyaz() {
        if (checkBoxSuffle.isChecked()) {

            Integer length = WordList.length;
            Random rnd = new Random();
            Integer sayi = rnd.nextInt(length);

            if (AskList == null) AskList = new ArrayList<Integer>();
            if (AskList.size() == length) AskList = new ArrayList<Integer>();


            while ((length > 1 && AskList.indexOf(sayi) != -1)) {
                sayi = rnd.nextInt(length);
            }

            AskList.add(sayi);
            textViewWordCount.setText(String.valueOf(AskList.size()) + "/" + String.valueOf(WordList.length));


            String ask;
            if (!checkBoxTr_En.isChecked()) {
                ask = WordList[sayi][0];
                answer = WordList[sayi][1];
            } else {
                ask = WordList[sayi][1];
                answer = WordList[sayi][0];
            }

            textViewWord.setText(ask);
            editTextAnswer.setText("");
        } else {
            AskList = null;
            Integer length = WordList.length;

            String ask;
            if (!checkBoxTr_En.isChecked()) {
                ask = WordList[lastNumNormal][0];
                answer = WordList[lastNumNormal][1];
            } else {
                ask = WordList[lastNumNormal][1];
                answer = WordList[lastNumNormal][0];
            }

            textViewWord.setText(ask);
            editTextAnswer.setText("");
            if (lastNumNormal < length - 1) {
                lastNumNormal++;
            } else {
                lastNumNormal = 0;
            }

            if (lastNumCount == length) {
                lastNumCount = 0;
            }
            lastNumCount++;
            textViewWordCount.setText(lastNumCount + "/" + WordList.length);
        }

        textViewAnswer.setText("Answer");
    }

    private void loadListDialog() {
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(MainActivity.this);
        //        builderSingle.setIcon(R.mipmap.ic_launcher);
        builderSingle.setTitle("Kategorini Seç");

        // , , , Sayılar
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, R.layout.custom_alertdialog);
        arrayAdapter.add("Sıfatlar - " + Words.Sifatlar.length);
        arrayAdapter.add("Nesneler - " + Words.Nesneler.length);
        arrayAdapter.add("Meyveler ve Sebzeler - " + Words.Fruit.length);
        arrayAdapter.add("Fiiller - " + Words.Fiiller.length);
        arrayAdapter.add("Aile ve İlişki - " + Words.Aileiliski.length);
        arrayAdapter.add("Meslekler - " + Words.Meslekler.length);
        arrayAdapter.add("Yerler - " + Words.Yerler.length);
        arrayAdapter.add("Renkler - " + Words.Renkler.length);
        arrayAdapter.add("Hayvanlar - " + Words.Hayvanlar.length);
        arrayAdapter.add("Vücut - " + Words.Vucut.length);
        arrayAdapter.add("Zaman - " + Words.Zaman.length);
        arrayAdapter.add("Hepsi - " + allListCount);

        builderSingle.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String strName = arrayAdapter.getItem(which);
                String selectName = "";
                switch (strName.substring(0, strName.indexOf(' '))) {
                    case "Sıfatlar":
                        WordList = Words.Sifatlar;
                        selectName = "Sıfatlar";
                        break;
                    case "Nesneler":
                        WordList = Words.Nesneler;
                        selectName = "Nesneler";
                        break;
                    case "Meyveler":
                        WordList = Words.Fruit;
                        selectName = "Meyveler ve Sebzeler";
                        break;
                    case "Fiiller":
                        WordList = Words.Fiiller;
                        selectName = "Fiiller";
                        break;
                    case "Aile":
                        WordList = Words.Aileiliski;
                        selectName = "Aile ve İlişkiler";
                        break;
                    case "Meslekler":
                        WordList = Words.Meslekler;
                        selectName = "Meslekler";
                        break;
                    case "Yerler":
                        WordList = Words.Yerler;
                        selectName = "Yerler";
                        break;
                    case "Renkler":
                        WordList = Words.Renkler;
                        selectName = "Renkler";
                        break;
                    case "Hayvanlar":
                        WordList = Words.Hayvanlar;
                        selectName = "Hayvanlar";
                        break;
                    case "Vücut":
                        WordList = Words.Vucut;
                        selectName = "Vücut";
                        break;
                    case "Zaman":
                        WordList = Words.Zaman;
                        selectName = "Zaman";
                        break;
                    case "Hepsi":
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                String[][] total = new String[Integer.valueOf(allListCount)][2];
                                int tt = 0;
                                for (int i = 0; i < allList.size(); i++) {
                                    for (int k = 0; k < allList.get(i).length; k++) {
                                        total[tt] = allList.get(i)[k];
                                        tt++;
                                    }
                                }
                                WordList = total;
                            }
                        }).run();


                        selectName = "Hepsi";
                        break;
                    default:
                        WordList = Words.Nesneler;
                        selectName = "Nesneler";
                        break;
                }

                textViewSelectedArray.setText(selectName.toUpperCase());
                AskList = new ArrayList<Integer>();
                textViewCount.setText(String.valueOf(WordList.length) + " kelime var!");
                lastNumNormal = 0;
                lastNumCount = 0;
                textViewWordCount.setText("1/" + String.valueOf(WordList.length));
                textViewAnswer.setText("Answer");
                sorubulyaz();
                dialog.dismiss();
            }
        });
        builderSingle.show();
    }


    private LinearLayout lq, lw, le, lr, lt, ly, lu, lii, lo, lp, lgg, luu, la, ls, ld, lf, lg, lh, lj, lk, ll, lss, li, lz, lx, lc, lv, lb, ln, lm, loo, lcc;
    private LinearLayout lDel, lVib, lSound, lSpace, lEnter;
    private ImageView iVib, iSound, iDelete;
    private String[] keyList = {"q","w","e","r","t","y","u","ı","o","p","ğ","ü","a","s","d","f","g","h","j","k","l","ş","i","z","x","c","v","b","n","m","ö","ç"};

    @SuppressLint("ClickableViewAccessibility")
    private void loadKeyboardKey() {
        // region create linearlayouts
        lq = (LinearLayout) findViewById(R.id.lq);
        lw = (LinearLayout) findViewById(R.id.lw);
        le = (LinearLayout) findViewById(R.id.le);
        lr = (LinearLayout) findViewById(R.id.lr);
        lt = (LinearLayout) findViewById(R.id.lt);
        ly = (LinearLayout) findViewById(R.id.ly);
        lu = (LinearLayout) findViewById(R.id.lu);
        lii = (LinearLayout) findViewById(R.id.lı);
        lo = (LinearLayout) findViewById(R.id.lo);
        lp = (LinearLayout) findViewById(R.id.lp);
        lgg = (LinearLayout) findViewById(R.id.lğ);
        luu = (LinearLayout) findViewById(R.id.lü);
        la = (LinearLayout) findViewById(R.id.la);
        ls = (LinearLayout) findViewById(R.id.ls);
        ld = (LinearLayout) findViewById(R.id.ld);
        lf = (LinearLayout) findViewById(R.id.lf);
        lg = (LinearLayout) findViewById(R.id.lg);
        lh = (LinearLayout) findViewById(R.id.lh);
        lj = (LinearLayout) findViewById(R.id.lj);
        lk = (LinearLayout) findViewById(R.id.lk);
        ll = (LinearLayout) findViewById(R.id.ll);
        lss = (LinearLayout) findViewById(R.id.lş);
        li = (LinearLayout) findViewById(R.id.li);
        lz = (LinearLayout) findViewById(R.id.lz);
        lx = (LinearLayout) findViewById(R.id.lx);
        lc = (LinearLayout) findViewById(R.id.lc);
        lv = (LinearLayout) findViewById(R.id.lv);
        lb = (LinearLayout) findViewById(R.id.lb);
        ln = (LinearLayout) findViewById(R.id.ln);
        lm = (LinearLayout) findViewById(R.id.lm);
        loo = (LinearLayout) findViewById(R.id.lö);
        lcc = (LinearLayout) findViewById(R.id.lç);

        lDel = (LinearLayout) findViewById(R.id.ldel);
        lVib = (LinearLayout) findViewById(R.id.lvibration);
        lSound = (LinearLayout) findViewById(R.id.lsound);
        lSpace  = (LinearLayout) findViewById(R.id.lspace);
        lEnter = (LinearLayout) findViewById(R.id.lenter);
        //endregion

        LinearLayout[] lList = {lq, lw, le, lr, lt, ly, lu, lii, lo, lp, lgg, luu, la, ls, ld, lf, lg, lh, lj, lk, ll, lss, li, lz, lx, lc, lv, lb, ln, lm, loo, lcc};
        for (int i = 0; i < lList.length; i++) {
            final int _i = i;
            lList[i].setOnTouchListener(new View.OnTouchListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    CustomSettings.Vibration(MainActivity.this, 60);
                    CustomSettings.loadClickSound(MainActivity.this);

                    editTextAnswer.setText(editTextAnswer.getText() + keyList[_i]);
                    editTextAnswer.setSelection(editTextAnswer.getText().length());
                    editTextAnswer.setCursorVisible(true);

                    return false;
                }
            });
        }


        lDel.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                CustomSettings.Vibration(MainActivity.this, 60);
                CustomSettings.loadClickSound(MainActivity.this);

                if (!String.valueOf(editTextAnswer.getText()).equals("")) {
                    editTextAnswer.setText(editTextAnswer.getText().subSequence(0, editTextAnswer.getText().length() - 1));
                    editTextAnswer.setSelection(editTextAnswer.getText().length());
                }

                return false;
            }
        });

        lSpace.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                CustomSettings.Vibration(MainActivity.this, 60);
                CustomSettings.loadClickSound(MainActivity.this);

                if (editTextAnswer.getText() != null) {
                    editTextAnswer.setText(editTextAnswer.getText() + " ");
                    editTextAnswer.setSelection(editTextAnswer.getText().length());
                }

                return false;
            }
        });

        lEnter.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                CustomSettings.Vibration(MainActivity.this, 60);

                if (editTextAnswer.getText() != null) {
                    if (String.valueOf(editTextAnswer.getText()).toLowerCase().equals(answer.toLowerCase()))
                        sorubulyaz();
                }

                return false;
            }
        });

        iVib = (ImageView) findViewById(R.id.iVib);
        lVib.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                CustomSettings.loadClickSound(MainActivity.this);

                if (CustomSettings.isVibration) {
                    CustomSettings.isVibration = false;

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("isVibration", false);
                    editor.apply();

                    iVib.setImageResource(R.drawable.ic_vibration_off);
                } else {
                    CustomSettings.isVibration = true;
                    CustomSettings.Vibration(MainActivity.this, 60);

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("isVibration", true);
                    editor.apply();

                    iVib.setImageResource(R.drawable.ic_vibration_on);
                }

                return false;
            }
        });

        iSound = (ImageView) findViewById(R.id.iSound);
        lSound.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                CustomSettings.Vibration(MainActivity.this, 60);

                if (CustomSettings.isSound) {
                    CustomSettings.isSound = false;

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("isSound", false);
                    editor.apply();

                    iSound.setImageResource(R.drawable.ic_sound_off);
                } else {
                    CustomSettings.isSound = true;
                    CustomSettings.Vibration(MainActivity.this, 60);

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("isSound", true);
                    editor.apply();

                    iSound.setImageResource(R.drawable.ic_sound_on);
                }

                return false;
            }
        });

        iDelete = (ImageView) findViewById(R.id.iDelete);
        iDelete.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                CustomSettings.Vibration(MainActivity.this, 60);
                CustomSettings.loadClickSound(MainActivity.this);

                editTextAnswer.setText("");

                return false;
            }
        });
    }

    private SharedPreferences sharedPreferences;
    private void SoundAndVibrationCheck() {

        if (sharedPreferences.getBoolean("isSound", true)) {
            CustomSettings.isSound = true;
            iSound.setImageResource(R.drawable.ic_sound_on);
        } else {
            CustomSettings.isSound = false;
            iSound.setImageResource(R.drawable.ic_sound_off);
        }

        if (sharedPreferences.getBoolean("isVibration", true)) {
            CustomSettings.isVibration = true;
            iVib.setImageResource(R.drawable.ic_vibration_on);
        } else {
            CustomSettings.isVibration = false;
            iVib.setImageResource(R.drawable.ic_vibration_off);
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isSound", CustomSettings.isSound);
        editor.putBoolean("isVibration", CustomSettings.isVibration);
        editor.apply();

    }
}