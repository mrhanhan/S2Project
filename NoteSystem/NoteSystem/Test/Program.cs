using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NoteSystem.DataManage;
using NoteSystem;
using NoteSystem.Modles;
using System.Drawing;
using NoteSystem.Modles.Node;

namespace Test
{
    class Program
    {
        static void Main(string[] args)
        {

            ConfigSeting cs = ConfigSeting.Config;
            

            NoteDateFileOper ddf = new NoteDateFileOper();
            object o = ddf.ReadNoteFileDate();
            UserInfoOper uio = new UserInfoOper();
         //   uio.deleteUserInfo("韩浩");
            
           NoteBlock nb  = uio.getNoteBlock("韩浩");

            NoteType nt = new NoteType("第一次状态");
            nt.Title = "哈哈";
            nb.AllNode.Add(nt);
            uio.flushFile();

            nb = uio.getNoteBlock("韩浩");

            
        }
    }
}
