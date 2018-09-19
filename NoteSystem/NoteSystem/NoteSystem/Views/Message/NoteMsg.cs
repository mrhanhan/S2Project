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
    public partial class NoteMsg :BaseNoteForm
    {
        private  NoteMsg(string title,string msg)
        {
            InitializeComponent();
            this.label1.Text = title;
            this.label2.Text = msg;
            this.IsFixed = true;
           
        }

       private void button1_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        public static DialogResult Show(string title, string msg)
        {
            return new NoteMsg(title, msg).ShowDialog();
        }
        public static void Toast(string title, string msg)
        {
            NoteMsg notmsgh= new NoteMsg(title, msg);
            notmsgh.button1.Visible = false;
            notmsgh.button2.Visible = false;
            notmsgh.Show();
            notmsgh.timer1.Start();
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
