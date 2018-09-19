using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;
using System.Windows.Forms;
namespace NoteSystem.Views.Component
{
   public class LayoutControl:Panel
    {

       
        protected override void OnPaintBackground(PaintEventArgs e)
        {
            // 使用双缓冲
            this.DoubleBuffered = true;
            e.Graphics.SmoothingMode = System.Drawing.Drawing2D.SmoothingMode.Default;
            // if(i<10)
              base.OnPaintBackground(e);
            //  i++;
           // e.Graphics.Clear(Color.Transparent);
        }
       
    }
}
