using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace NoteSystem.Views.Message
{
    public partial class InputMsg : BaseNoteForm
    {
        public InputMsg(string tit,string msg)
        {
            
            InitializeComponent();

            this.labTitle.Text = tit;
            this.txtMsg.Text = msg;
            IsFixed = true;
        }
        public string Msg = "";

       
        private void button1_Click(object sender, EventArgs e)
        {
            Msg = textMsg.Text;
        }
        /// <summary>
        /// 弹出输入框
        /// </summary>
        /// <param name="tit"></param>
        /// <param name="msg"></param>
        /// <returns></returns>
        public static InputQuery Show(string tit,string msg)
        {
            InputMsg im = new InputMsg(tit, msg);
            InputQuery iq = new InputQuery();
            iq.Dr = im.ShowDialog();
            iq.InputMsg = im.Msg;
            return iq;
        }
    }

    public class InputQuery
    {
        DialogResult dr;
        string inputMsg;

        public DialogResult Dr
        {
            get
            {
                return dr;
            }

            set
            {
                dr = value;
            }
        }

        public string InputMsg
        {
            get
            {
                return inputMsg;
            }

            set
            {
                inputMsg = value;
            }
        }
    }
}
