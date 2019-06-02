package com.example.user.myasssistant;

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.*;
import java.io.FileReader;

class UserLogins {

    protected boolean fileReader(String[] userdata,Context context) throws Exception {

        String string;
        String[] user = new String[2];

        try {
            File f = new File(context.getFilesDir().getAbsolutePath()+"Users.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            while ((string = br.readLine()) != null) {
                user[0] = string.substring(0,string.indexOf(":"));
                user[1] = string.substring(string.indexOf(":")+1);
                if(user[0].equals(userdata[0]) && user[1].equals(userdata[1]))
                {
                    return true;
                }
            }
            fr.close();
            return false;
        } catch (Exception e) {
            throw e;
        }

    }

    protected boolean fileWriter(String[] userdata, Context context) throws Exception {
        String string;
        string = userdata[0] +":" +userdata[1] +"\n";
        try{

            File f = new File(context.getFilesDir().getAbsolutePath()+"Users.txt");
            if(f.exists())
            {
                if(fileReader(userdata,context))
                {
                    Toast t = Toast.makeText(context,"The User Is Already Registered",Toast.LENGTH_LONG);
                    t.show();
                    return false;
                }
                else
                {
                    FileWriter fw  = new FileWriter(f,true);
                    fw.append(string);
                    fw.close();
                    return true;
                }
            }
            else {
                FileWriter fw = new FileWriter(f, true);
                fw.append(string);
                fw.close();
                return true;
            }
        }catch(Exception e)
        {
            throw e;
        }
    }

    protected void deleteUser(String[] userdata,Context context) throws Exception {
        try{
            File f = new File(context.getFilesDir().getAbsolutePath()+"Users.txt");
            String string = userdata[0] + ":" + userdata[1];
            String delete;
            String content ="";
            if(f.exists())
            {
               if(fileReader(userdata, context))
               {
                  BufferedReader br = new BufferedReader(new FileReader(f));
                  while((delete = br.readLine())!= null)
                  {
                      if(delete.equals(string))
                      {
                          Toast t = Toast.makeText(context,"The User " + userdata[0] + "is deleted",Toast.LENGTH_SHORT);
                          t.show();
                          continue;
                      }
                      content += delete + "\n";
                  }
                   br.close();
                  BufferedWriter bw = new BufferedWriter(new FileWriter(f));
                  bw.write(content);
                  bw.close();
               }
               else
               {
                   Toast t = Toast.makeText(context,"The User Is Not Registered",Toast.LENGTH_SHORT);
                   t.show();
               }
            }

        }catch(Exception e)
        {
            throw e;
        }
    }

}
