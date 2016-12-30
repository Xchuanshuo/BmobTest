package com.mycompany.bob;
import android.support.v7.app.*;
import android.os.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;
import cn.bmob.v3.listener.*;
import cn.bmob.v3.*;

public class RegisterActivity extends AppCompatActivity
{
	private EditText edt1,edt2;
    private  Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		Bmob.initialize(this,"你的 APP key");
		setContentView(R.layout.register_main);
		edt1=(EditText)findViewById(R.id.register_edt1);
		edt2=(EditText)findViewById(R.id.register_edt2);
		btn=(Button)findViewById(R.id.register_zc);
		btn.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					Sign();
					// TODO: Implement this method
				}

			
		});
		}
		private void Sign(){
			LoginBeen lgb=new LoginBeen();
			lgb.setName("chuanshuo");
			lgb.setAge(17);
			lgb.setEmail("2414605975@qq.com");
			lgb.setUsername(edt1.getText().toString());
			lgb.setPassword(edt2.getText().toString());
			lgb.signUp(RegisterActivity.this, new InsertListener(){

					@Override
					public void onSuccess()
					{
			Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
			finish();
						// TODO: Implement this method
					}

					@Override
					public void onFailure(String p1)
					{
			Toast.makeText(RegisterActivity.this,"请稍后再试",Toast.LENGTH_SHORT).show();
						// TODO: Implement this method
					}

				
			});
		}
	}
