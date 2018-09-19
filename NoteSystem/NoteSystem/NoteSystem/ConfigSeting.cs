using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
namespace NoteSystem
{
    /// <summary>
    /// 配置设置类
    /// </summary>
    public class ConfigSeting
    {
        private static ConfigSeting config;

        public static ConfigSeting Config
        {
            get
            {
                if (config == null)
                    config = new ConfigSeting();
                return config;
            }
        }
        /// <summary>
        /// 用户图片路径
        /// </summary>
        public string BackImagesFile
        {
            get
            {
                return rootPath + back;
            }

        }
        /// <summary>
        /// 获取系统文件路径
        /// </summary>
        public string NoteFiles
        {
            get
            {
                return rootPath+noteFiles;
            }
        }

        public string Note
        {
            get { return NoteFiles + "\\Nodes\\"; }
        }

        private ConfigSeting(){
            //获取当前相对路径的绝对路径
           rootPath = Path.GetFullPath(".\\");
            ///判断文件夹是否存在
            DirectoryInfo directoy = new DirectoryInfo(rootPath+back);
            if (!directoy.Exists)
            {
                //创建文件夹
                directoy.Create();
            }
            directoy = new DirectoryInfo(rootPath + noteFiles);
            
            if (!directoy.Exists)
            {
                //创建文件夹
                directoy.Create();
            }
            directoy = new DirectoryInfo(Note);

            if (!directoy.Exists)
            {
                //创建文件夹
                directoy.Create();
            }
        }
        /// <summary>
        /// 根目录
        /// </summary>
        private string rootPath;

        private string back="NoteData\\";
        private string noteFiles = "NoteFile\\";
    }
}
