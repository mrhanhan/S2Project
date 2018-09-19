using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BookManagerSystem
{
    public partial class ErrorForm : Form
    {


        BookDatabaseOption option = BookDatabaseOption.BookDatabaseOpeion;
        public ErrorForm()
        {
            InitializeComponent();
            option.AddError = error;
        }
        private void ErrorForm_Load(object sender, EventArgs e)
        {
            List<ErrorMsg> em = option.ErrorMsg;
            for(int i = 0; i < em.Count; i++)
            {
                ErrorMsg e1 = em[i];
                ListViewItem lvi = new ListViewItem(e1.Date);
                lvi.SubItems.Add(new ListViewItem.ListViewSubItem(lvi,e1.ErrorMessage));
                listView1.Items.Add(lvi);
            }
        }

        private void error(ErrorMsg e1)
        {
            ListViewItem lvi = new ListViewItem(e1.Date);
            lvi.SubItems.Add(new ListViewItem.ListViewSubItem(lvi, e1.ErrorMessage));
        }
    }
}
