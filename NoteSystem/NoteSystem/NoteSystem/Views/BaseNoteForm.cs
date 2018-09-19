using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace NoteSystem
{
    public partial class BaseNoteForm : Form
    {
        private bool isFixed = false;//是否固定大小
        private int _Height;
        public BaseNoteForm()
        {
            InitializeComponent();
            this.Icon = Icon.FromHandle(new Bitmap(global::NoteSystem.Properties.Resources.NoteLogo).GetHicon());
            _Height = Height;
        }

        

        //是否移动
        private bool __isMove = false;
        //方向
        private int __UD = 0;
        /// <summary>
        /// 是否调整大小
        /// </summary>
        private bool __isReSize = false;
        private int initX, initY;//初始化坐标

        protected bool IsFixed
        {
            get
            {
                return isFixed;
            }

            set
            {
                isFixed = value;
            }
        }
          /*
        protected override CreateParams CreateParams
        {
            get
            {
                CreateParams cp = base.CreateParams;
                cp.ExStyle |= 0x02000000;
                return cp;
            }
        }

      */
        protected void NoteForm_MouseDown(object sender, MouseEventArgs e)
        {
            ///判断是否右键按下
            if (e.Button == MouseButtons.Left)
            {
                int x = MousePosition.X, y = MousePosition.Y;
                initX = x;
                int acc = 10;
                initY = y;
                bool can = true;

                if (this.Width < this.MinimumSize.Width)
                {
                    can = false;
                    
                }
                if (this.Height < this.MinimumSize.Height)
                {
                    can = false;
                }


                ///判断鼠标位置是否数是在边框
                if (Math.Abs(x - this.Left) < acc && Math.Abs(y - this.Top) < acc && !IsFixed && can )
                {
                    __isReSize = true;
                    this.__UD = 1;
                    this.Cursor = Cursors.SizeNWSE;
                }else if (Math.Abs(x - this.Left-this.Width) < acc && Math.Abs(y - this.Top) < acc && !IsFixed && can)
                {
                    __isReSize = true;
                    this.__UD = 2;
                    this.Cursor = Cursors.SizeNESW;
                }
                 else if (Math.Abs(x - this.Left - this.Width) < acc && Math.Abs(y - this.Top - this.Height) < acc && !IsFixed && can)
                {
                    __isReSize = true;
                    this.__UD = 3;
                    this.Cursor = Cursors.SizeNWSE;
                } else if (Math.Abs(x - this.Left) < acc && Math.Abs(y- this.Top - this.Height) < acc && !IsFixed && can)
                {
                    __isReSize = true;
                    this.__UD = 4;
                    this.Cursor = Cursors.SizeNESW;
                }
                else if (Math.Abs(x - this.Left) < acc && !IsFixed && can)
                {
                    __isReSize = true;
                    this.__UD = 5;
                    this.Cursor = Cursors.SizeWE;
                }
                else if (Math.Abs(x - this.Left - this.Width) < acc && !IsFixed && can)
                {
                    __isReSize = true;
                    this.__UD = 7;
                    this.Cursor = Cursors.SizeWE;
                }
                else if ( Math.Abs(y - this.Top - this.Height) < acc && !IsFixed && can)
                {
                    __isReSize = true;
                    this.__UD = 8;
                    this.Cursor = Cursors.SizeNS;
                }
                else if ( Math.Abs(y - this.Top ) < acc && !IsFixed && can)
                {
                    __isReSize = true;
                    this.__UD = 6;
                    this.Cursor = Cursors.SizeNS;
                }
                else
                {
                    __isMove = true;
                    this.Cursor = Cursors.SizeAll;

                }
            }
        }

        protected void NoteForm_MouseUp(object sender, MouseEventArgs e)
        {
            ///判断是否右键按下
            if (__isMove )
            {
                __isMove = false;
                this.Cursor = Cursors.Default;
            }
            ///判断是否右键按下
            if (__isReSize)
            {
                __isReSize = false;
                this.Cursor = Cursors.Default;
            }
        }

        protected void MenuLayout_Layout(object sender, LayoutEventArgs e)
        {

        }

        protected void closebtn_Click(object sender, EventArgs e)
        {
            this.Close();
        }
        

        private void BaseNoteForm_Resize(object sender, EventArgs e)
        {
           
        }

        private void btnMinShow_Click(object sender, EventArgs e)
        {
            this.WindowState = FormWindowState.Minimized;
        }

        private void btnMaxShow_Click(object sender, EventArgs e)
        {
           if(this.WindowState== FormWindowState.Maximized)
            {
                this.WindowState = FormWindowState.Normal;
                this.btnMaxShow.Text = "回";
                
            }
            else
            {
                this.WindowState = FormWindowState.Maximized;
                
                this.btnMaxShow.Text = "口";
            }
        }

        protected void NoteForm_MouseMove(object sender, MouseEventArgs e)
        {

            ///判断是否右键按下
           bool can = true;

            if (this.Width < this.MinimumSize.Width)
            {
                can = false;

            }
            if (this.Height < this.MinimumSize.Height)
            {
                can = false;
            }
          //  Console.WriteLine("Width{0} Min{1} Can{2}",Width,MinimumSize.Width,can);
            if (e.Button == MouseButtons.Left && __isReSize)
            {

                int cx= MousePosition.X;//根据鼠标x坐标确定窗体的左边坐标x  
                int cy= MousePosition.Y ;//根据鼠标的y坐标窗体的顶部，即Y坐标  
                int h1, w1;
                if (!can)
                    return;
                switch (__UD)
                {
                    ///右上
                    case 1:
                         w1 = Left + Width;//保存最左边到屏幕的距离
                        this.Width = w1 - cx;//总距离减去先鼠标位置，得到宽度
                        this.Left = cx;

                        //保存之前的高度
                        h1 = (Top + Height);
                        this.Height = (h1 - cy);
                        this.Top = cy;
                        break;
                    ///左上
                    case 2:
                        this.Width = MousePosition.X - this.Left;
                        //保存之前的高度
                        h1 = (Top + Height);
                        this.Height = (h1 - cy);
                        this.Top = cy;
                        break;
                    ///左下
                    case 3:
                        this.Width = MousePosition.X - this.Left;
                        this.Height = cy - this.Top;
                        break;
                    ///右下
                    case 4:
                         w1 = Left + Width;//保存最左边到屏幕的距离
                        this.Width = w1 - cx;//总距离减去先鼠标位置，得到宽度
                        this.Left = cx;
                        this.Height = cy - this.Top;
                        break;
                    ///右
                    case 5:
                         w1 = Left + Width;//保存最左边到屏幕的距离
                        this.Width = w1 - cx;//总距离减去先鼠标位置，得到宽度
                        this.Left = cx;

                        break;
                    ///上
                    case 6:
                        //保存之前的高度
                         h1 = (Top+Height);
                        this.Height = (h1-cy);
                        this.Top=cy;
                       // Console.WriteLine(" H1:{0} CH:{1} ",h1, Top + Height);
                        break;
                    ///左
                    case 7:
                        this.Width=MousePosition.X-this.Left;
                        break;
                    ///下
                    case 8:
                        this.Height= cy-this.Top;
                        break;


                } ///判断是否右键按下

               

                //  Console.WriteLine("U:{0} L:{1} T:{2}  W:{3} H:{4} ",__UD,Left,Top,Width,Height);

            }
            else if (e.Button == MouseButtons.Left && __isMove)
            {

                this.Left += MousePosition.X - initX;//根据鼠标x坐标确定窗体的左边坐标x  
                this.Top += MousePosition.Y - initY;//根据鼠标的y坐标窗体的顶部，即Y坐标  
                initX = MousePosition.X;
                initY = MousePosition.Y;

            }
            initX = MousePosition.X;
            initY = MousePosition.Y;
        }
    }
}
