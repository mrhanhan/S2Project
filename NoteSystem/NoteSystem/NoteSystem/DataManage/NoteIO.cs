using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using System.Runtime.Serialization.Formatters.Binary;
namespace NoteSystem.DataManage
{
    
    public class NoteIO
    {
        public  bool SaveObjectFile(string path,object obj)
        {
            FileStream fs=null;
            BinaryFormatter bf;
            try { 
               fs= new FileStream(path, FileMode.OpenOrCreate, FileAccess.ReadWrite);
                bf = new BinaryFormatter();
                bf.Serialize(fs, obj);
                fs.Flush();

            } catch(Exception e1)
            {
                return false;
            }
            finally
            {
                if (fs != null)
                {
                    fs.Close();
                }
            }
            return true;
        }
        public T ReadObjectFile<T>(string path)
        {
            FileStream fs = null;
            BinaryFormatter bf;
            T t =default(T) ;
            try
            {
                fs = new FileStream(path, FileMode.OpenOrCreate, FileAccess.ReadWrite);
                bf = new BinaryFormatter();
                 t = (T)bf.Deserialize(fs);
                fs.Flush();

            }
            catch (Exception e1)
            {
                return t;
            }
            finally
            {
                if (fs != null)
                {
                    fs.Close();
                }
            }
            return t;
        }
    }
}
