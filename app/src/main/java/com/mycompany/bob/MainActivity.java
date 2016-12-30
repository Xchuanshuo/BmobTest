package com.mycompany.bob;

import android.app.*;
import android.os.*;
import android.support.v7.app.*;
import cn.bmob.v3.*;
import android.widget.*;
import android.support.v7.app.AlertDialog;
import android.view.View.*;
import android.view.*;
import cn.bmob.v3.listener.*;
import android.content.*;

public class MainActivity extends AppCompatActivity implements OnClickListener
{
	private Button btn1,btn2,btn3,btn4,btn5;
	private EditText edt1,edt2,edt3,edt4;
	private TextView tv1,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		Bmob.initialize(this,"你的APP key");
        setContentView(R.layout.main);
		btn1=(Button)findViewById(R.id.btn1);
		btn2=(Button)findViewById(R.id.btn2);
		btn3=(Button)findViewById(R.id.btn3);
		btn4=(Button)findViewById(R.id.btn4);
		btn5=(Button)findViewById(R.id.btn5);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		btn5.setOnClickListener(this);
		edt1=(EditText)findViewById(R.id.edt1);
		edt2=(EditText)findViewById(R.id.edt2);
		edt3=(EditText)findViewById(R.id.edt3);
		edt4=(EditText)findViewById(R.id.edt4);
		tv2=(TextView)findViewById(R.id.tv2);
		tv1=(TextView)findViewById(R.id.tv1);
		tv2.setOnClickListener(this);
		tv1.setOnClickListener(this);
    }

	@Override
	public void onClick(View p1)
	{
		switch(p1.getId()){
			case R.id.btn1:
           String name=edt1.getText().toString();
		   String address=edt2.getText().toString();
		   TestBeen test=new TestBeen();
		 
		   test.setName(name);
		   test.setAddress(address);
		   if(name.equals(" ")||address.equals(" ")){
			   return;
		   }
				test.insertObject(this, new InsertListener(){

						@Override
						public void onSuccess()
						{
					Toast.makeText(MainActivity.this,"添加成功",Toast.LENGTH_SHORT).show();
							// TODO: Implement this method
						}

						@Override
						public void onFailure(String p1)
						{
					Toast.makeText(MainActivity.this,"添加失败",Toast.LENGTH_SHORT).show();
							// TODO: Implement this method
						}
			   
		   });
		   break;
		   case R.id.btn2:
			   BmobQuery<TestBeen> query=new BmobQuery<TestBeen>();
			  
				query.getObject(this, "538961bb0b", new GetListener<TestBeen>(){

						@Override
						public void onSuccess(TestBeen p1)
						{
			Toast.makeText(MainActivity.this,"查询成功"+"名称:"+p1.getName(),Toast.LENGTH_SHORT).show();
							// TODO: Implement this method
						}

						@Override
						public void onFailure(String p1)
						{
							// TODO: Implement this method
						}

				   
			   });
			   break;
			case R.id.btn3:
			final	TestBeen te=new TestBeen();
				te.setAddress("甜蜜的伤口");
				te.updateObject(this, "538961bb0b", new UpdateListener(){

						@Override
						public void onSuccess()
						{
				Toast.makeText(MainActivity.this,"更新成功"+te.getAddress(),Toast.LENGTH_SHORT).show();
							// TODO: Implement this method
						}

						@Override
						public void onFailure(String p1)
						{
							// TODO: Implement this method
						}

				});
				break;
			case R.id.btn4:
				TestBeen tt=new TestBeen();
				tt.setObjectId("538961bb0b");
				tt.deleteObject(this, new DeleteListener(){

						@Override
						public void onSuccess()
						{
					Toast.makeText(MainActivity.this,"删除成功",Toast.LENGTH_SHORT).show();
							// TODO: Implement this method
						}

						@Override
						public void onFailure(String p1)
						{
	
							// TODO: Implement this method
						}
					
				});
				break;
			case R.id.btn5:
				LoginBeen lgb=new LoginBeen();
				lgb.setUsername(edt3.getText().toString());
				lgb.setPassword(edt4.getText().toString());
				lgb.login(MainActivity.this, new InsertListener(){

						@Override
						public void onSuccess()
						{
					login();
			
							// TODO: Implement this method
						}

						@Override
						public void onFailure(String p1)
						{
				Toast.makeText(MainActivity.this,"您输入的帐号或密码错误",Toast.LENGTH_SHORT).show();
							// TODO: Implement this method
						}

					
				});
				break;
				case R.id.tv1:
					Intent intent=new Intent();
					intent.setClass(this,RegisterActivity.class);
					startActivity(intent);
				break;
				case R.id.tv2:
					String email="2414605975@qq.com";
				BmobUser.resetPassword(MainActivity.this, email, new ResetPasswordListener(){

						@Override
						public void onSuccess()
						{
				Toast.makeText(MainActivity.this,"验证已经发往邮箱",Toast.LENGTH_SHORT).show();
							// TODO: Implement this method
						}

						@Override
						public void onFailure(String p1)
						{
							// TODO: Implement this method
						}

						
					});
					break;
		}
		
		// TODO: Implement this method
	}
	private void login(){
		AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
			builder.setTitle("欢迎使用");
			builder.setMessage("请遵循我们的使用规则");
	
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener(){
   
									@Override
									public void onClick(DialogInterface p1, int p2)
									{
							Toast.makeText(MainActivity.this,"感谢您的使用",Toast.LENGTH_SHORT).show();
										// TODO: Implement this method
									}
				
			});
			builder.show();
	}

}
