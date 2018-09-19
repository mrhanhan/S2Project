using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NoteSystem.Modles;
using NoteSystem;
namespace NoteSystem.DataManage
{
    /// <summary>
    /// 便签文件操作类
    /// </summary>
   public class NoteDateFileOper:NoteIO
    {
        /// <summary>
        /// 保存系统文件
        /// </summary>
        /// <param name="nad"></param>
        /// <returns></returns>
        public bool SaveNoteAllDate(NoteAllData nad)
        {
            ConfigSeting cs = ConfigSeting.Config;
            return SaveObjectFile(cs.NoteFiles + "System.noteSys", nad); ;
        }
        /// <summary>
        /// 读取系统文件
        /// </summary>
        /// <returns></returns>
        public NoteAllData ReadNoteFileDate()
        {
            ConfigSeting cs = ConfigSeting.Config;
            string path = cs.NoteFiles + "System.noteSys";
            NoteAllData dad = null;
            if (System.IO.File.Exists(path))//判断是否存在系统文件{
            {
                dad = ReadObjectFile<NoteAllData>(path);
                //当dad=null时说明读取错误
                while (dad == null)
                {
                    //  System.IO.File.Create(path);
                    dad = NoteAllData.createNewNoteAllDate();//创建新的系统文件对象
                    SaveNoteAllDate(dad);//保存
                    dad = ReadNoteFileDate();
                }
            }
            else
            {
                //  System.IO.File.Create(path);
                dad = NoteAllData.createNewNoteAllDate();//创建新的系统文件对象
                SaveNoteAllDate(dad);//保存
                dad = ReadNoteFileDate();
            }



            if (dad != default(NoteAllData) )//判断对象是否数default创建出来的
                return dad;
            return null;
        }
        /// <summary>
        /// 保存日志文件
        /// </summary>
        /// <param name="name"></param>
        /// <param name="nb"></param>
        /// <returns></returns>
        public bool SaveNoteFile(string name, NoteBlock nb)
        {
            ConfigSeting cs = ConfigSeting.Config;
            return SaveObjectFile(cs.Note+ name + ".noteblock", nb);

        }
        /// <summary>
        /// 读取日志文件
        /// </summary>
        /// <param name="name"></param>
        /// <param name="nb"></param>
        /// <returns></returns>
        public NoteBlock ReadNoteFile(string name)
        {
            ConfigSeting cs = ConfigSeting.Config;
            string path = cs.Note + name+".noteblock";
            NoteBlock dad = null;
            if (System.IO.File.Exists(path))//判断是否存在系统文件
                dad = ReadObjectFile<NoteBlock>(path);
            if (dad != default(NoteBlock))//判断对象是否数default创建出来的
                return dad;
            return null;
        }
        /// <summary>
        /// 保存便签节点文件(便签类型 、便签)
        /// </summary>
        /// <param name="name"></param>
        /// <param name="nb"></param>
        /// <returns></returns>
        public bool SaveNoteNodeFile(string path, NoteNode nb)
        {
            ConfigSeting cs = ConfigSeting.Config;
            return SaveObjectFile(path, nb);

        }
        /// <summary>
        /// 读取便签节点文件(便签类型 、便签)
        /// </summary>
        /// <param name="name"></param>
        /// <param name="nb"></param>
        /// <returns></returns>
        public NoteNode ReadNoteNodeFile(string path)
        {
            ConfigSeting cs = ConfigSeting.Config;

            NoteNode dad = null;
            if (System.IO.File.Exists(path))//判断是否存在系统文件
                dad = ReadObjectFile<NoteNode>(path);
            if (dad != default(NoteNode))//判断对象是否数default创建出来的
                return dad;
            return null;
        }
        /// <summary>
        /// 删除指定名称的便签
        /// </summary>
        /// <param name="name"></param>
        /// <returns></returns>
        public void DeleteBlokc(string name)
        {
            ConfigSeting cs = ConfigSeting.Config;
            string path = cs.Note + name + ".noteblock";
             System.IO.File.Delete(path);
        }
    }
}
