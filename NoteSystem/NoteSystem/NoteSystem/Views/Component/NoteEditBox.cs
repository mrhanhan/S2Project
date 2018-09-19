using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;

using NoteSystem.Modles.Node;
using NoteSystem.DataManage;
using NoteSystem.Views.Message;
using NoteSystem.Modles;

namespace NoteSystem.Views.Component
{
    public partial class NoteEditBox : UserControl
    {
        /// <summary>
        /// 是否创建新的
        /// </summary>
        private bool isCreate = true;

        private MessageOper msgOper = new MessageOper();

        /// <summary>
        /// 节点
        /// </summary>
        private Note note;
        /// <summary>
        /// 当前字体样式
        /// </summary>
        private Font nowFont;
        /// <summary>
        /// 当前色彩
        /// </summary>
        private Color nowColor = Color.Black;


        private Modles.Message.MessageItem lastStyle;//最后一次的样式

        private NoteOper oper;
        /// <summary>
        /// 判断是否加载完成
        /// </summary>
        private bool IsloadOk = false;
        private Keys nowDwonKey;//当前按下的键

        /// <summary>
        /// 导出Txt文本
        /// </summary>
        public void EmpTxt()
        {
            SaveFileDialog sfd = new SaveFileDialog();
            sfd.FileName = note.NoteBlock.Username+"("+note.Title + "[Txt])";
            sfd.Filter = "文本文件|*.txt";
            if (sfd.ShowDialog() == DialogResult.OK)
            {
                richTextBox1.SaveFile(sfd.FileName);
            }
        }

        public NoteEditBox(NoteOper oper)
        {
            InitializeComponent();
            this.oper = oper;
        }
        /// <summary>
        /// 创建新的节点
        /// </summary>
        public void CreateNote(Note nt)
        {
            note = nt;//创建新的节点
            isCreate = true;

            init();
        }
        /// <summary>
        /// 编辑Note
        /// </summary>
        /// <param name="n"></param>
        public void EditNote(Note n)
        {
            this.note = n;
            isCreate = false;
           
            init();
        }
        private void init()
        {
          
            this.nowFont = Font;
            IsloadOk = false;

            richTextBox1.Clear();
            if (note.Msg != null)
            {
                msgOper.BindMessage = note.Msg;//绑定操作类
             
             richTextBox1.Text = note.Msg.MsgText;
                ///获取最未出的样式
                Modles.Message.MessageItem mmi = msgOper.getLastStyle();

                foreach(Modles.Message.MessageItem mi in note.Msg.Items)
                {
                    SetTextStyle(mi);
                }
                if (mmi!=null)
                {

                     nowFont = mmi.MsgFont;
                     nowColor = mmi.MsgColor;
                    lastStyle = mmi;
                    
                }
                else
                {
                    lastStyle= msgOper.createNowStyle(0, richTextBox1.Font, richTextBox1.ForeColor);
                }
                //设置预览样式

                //nowFont = mmi.MsgFont;
                //nowColor = mmi.MsgColor;
                styleText.Font = new Font(nowFont.FontFamily, 9f, nowFont.Style);
                styleText.ForeColor = nowColor;

            }
            if (string.IsNullOrEmpty(note.Title)) {
                note.Title = "新的便签";
            }
                fileName.Text = note.Title;
            showStyle();
            txtLines.Text = richTextBox1.Text.Split('\n').Length.ToString();
            txtSize.Text = richTextBox1.Text.Length.ToString();
            IsloadOk = true;
        }
        /// <summary>
        /// 显示样式
        /// </summary>
        private  void showStyle()
        {
            //if (note.Msg != null)
            //{
            //    for (int i=0;i<note.Msg.Items.Count;i++)
            //    {
            //        NoteSystem.Modles.Message.MessageItem mi = note.Msg.Items[i];
            //        richTextBox1.SelectionStart=mi.StartIndex;
            //        richTextBox1.SelectionLength= mi.Msglength;
            //        richTextBox1.SelectionColor = mi.MsgColor;
            //        richTextBox1.SelectionFont = mi.MsgFont;
                   
            //    }
            //    if(richTextBox1.TextLength>0)
            //    richTextBox1.Select(richTextBox1.TextLength, 0);
                
            //}
        }

        /// <summary>
        /// 显示当前样式
        /// </summary>
        private void nowStyle()
        {
            if (lastStyle != null) {

               // Console.WriteLine("S:{0} E{1} N:{2} C:{3}",lastStyle.StartIndex,lastStyle.EndIndex,richTextBox1.SelectionStart,lastStyle.MsgColor);
            nowFont = lastStyle.MsgFont;
            nowColor = lastStyle.MsgColor;
            styleText.Font = new Font(nowFont.FontFamily, 9f, nowFont.Style);
            styleText.ForeColor = nowColor;
            }
        }
        /// <summary>
        /// 设置字体样式
        /// </summary>
        /// <param name="mi"></param>
        private void SetTextStyle(NoteSystem.Modles.Message.MessageItem mi)
        {

            mi.StartIndex = (mi.StartIndex < 0 ? 0 : mi.StartIndex);
            mi.Msglength = (mi.Msglength < 0 ? 0 : mi.Msglength);

            richTextBox1.SelectionStart = mi.StartIndex;
            richTextBox1.SelectionLength = mi.Msglength;
            richTextBox1.SelectionColor = mi.MsgColor;
            richTextBox1.SelectionFont = mi.MsgFont;
           

        }
        /// <summary>
        /// 光标移动到最末端
        /// </summary>
        private void end()
        {
            richTextBox1.SelectionStart = richTextBox1.TextLength;
            richTextBox1.Focus();
        }
        /// <summary>
        /// 获取光标位置
        /// </summary>
        /// <returns></returns>
        private int getPoint()
        {
            return richTextBox1.SelectionStart;
        }
        /// <summary>
        /// 设置光标
        /// </summary>
        /// <param name="p">光标位置</param>
        private void setPoint(int p)
        {
            p=p < 1 ? 1 : p;
            richTextBox1.SelectionStart = p - 1;
            richTextBox1.SelectionLength = 0;
        }

        /// <summary>
        /// 字体样式
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void toolStripButton9_Click(object sender, EventArgs e)
        {
            FontDialog fd = new FontDialog();
            if (nowFont != null)
                fd.Font = nowFont;
            if (fd.ShowDialog() == DialogResult.OK)
            {
                this.nowFont = fd.Font;
                if (lastStyle.StartIndex == richTextBox1.SelectionStart)
                {
                    lastStyle.MsgFont = nowFont;
                   
                }
                else
                {
                    lastStyle.EndIndex = richTextBox1.TextLength;
                    lastStyle = msgOper.createNowStyle(richTextBox1.SelectionStart, nowFont == null ? Font : nowFont, nowColor == null ? ForeColor : nowColor);
                }
                styleText.Font = new Font(nowFont.FontFamily, 9f, nowFont.Style) ;
            }
        }
        /// <summary>
        /// 设置颜色
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void toolStripButton10_Click(object sender, EventArgs e)
        {
            ColorDialog cd = new ColorDialog();
            if (nowColor != null)
                cd.Color = nowColor;
            if (cd.ShowDialog() == DialogResult.OK)
            {
                nowColor = cd.Color;
                if (lastStyle.StartIndex == richTextBox1.SelectionStart)
                {
                    lastStyle.MsgColor = nowColor;
                }
                else
                {
                    lastStyle.EndIndex = richTextBox1.TextLength;
                    lastStyle = msgOper.createNowStyle(richTextBox1.SelectionStart, nowFont == null ? Font : nowFont, nowColor == null?ForeColor:nowColor);
                }
                styleText.ForeColor = cd.Color;
            }
        }
        int size = 0;
        private void richTextBox1_TextChanged(object sender, EventArgs e)
        {
            //设置大小
            txtLines.Text = richTextBox1.Text.Split('\n').Length.ToString();
            txtSize.Text = richTextBox1.Text.Length.ToString();
            int point = getPoint();//获取光标位置

            //添加数据
            if (nowDwonKey!= Keys.Back && IsloadOk)
            {
                if(lastStyle != null){ 
                   //lastStyle.EndIndex = richTextBox1.TextLength;

                    note.Msg.MsgText = richTextBox1.Text;

                     msgOper.InsertStyleIength(richTextBox1.TextLength-size, lastStyle);

                    size = richTextBox1.TextLength;


                    // lastStyle.EndIndex = richTextBox1.SelectionStart;
                    ///设置字体样式

                    SetTextStyle(lastStyle);
                    setPoint(point + 1);
                    styleText.Font = new Font(nowFont.FontFamily, 9f, nowFont.Style);
                    styleText.ForeColor = nowColor;
                   

                }
                else{
                    lastStyle  = msgOper.getStyle(richTextBox1.SelectionStart);
                }
                ///设置当前央视
                //nowStyle();
                ///设置光标
               
            }

        }

        private void richTextBox1_KeyDown(object sender, KeyEventArgs e)
        {
            //判断是否删除键按下
            nowDwonKey = e.KeyCode;
            int p = richTextBox1.SelectionStart;
            if (e.KeyCode == Keys.Back)
            {
                if (lastStyle == null)
                {
                    lastStyle = msgOper.getStyle(richTextBox1.SelectionStart);

                }
                if (note.Msg.Items.Count > 0)
                    msgOper.InsertStyleIength(richTextBox1.TextLength-size, lastStyle);
                size = richTextBox1.TextLength;
                //  lastStyle.Msglength=(lastStyle.StartIndex+lastStyle.Msglength-richTextBox1.SelectionStart);
                if (lastStyle.StartIndex > richTextBox1.TextLength)
                {
                    if (note.Msg.Items.Count > 1)
                    {
                        msgOper.DeleteStyle(lastStyle);//删除
                        lastStyle = msgOper.getStyle(richTextBox1.SelectionStart);
                    }
                        else
                        lastStyle.StartIndex = richTextBox1.TextLength - lastStyle.Msglength;
                   
                }
                lastStyle.StartIndex=( lastStyle.StartIndex < 0 ? 0 : lastStyle.StartIndex);
               lastStyle.Msglength=( lastStyle.Msglength < 0 ? 0 : lastStyle.Msglength);

                richTextBox1.SelectionStart = p;

            }
           

           // Console.WriteLine(InputLanguage.CurrentInputLanguage.Culture.());

           // if (e.KeyCode == Keys.Enter)
           // {
               
           // }
        }

        private void toolStripButton1_Click(object sender, EventArgs e)
        {
            IsloadOk = false;
            showStyle();
            IsloadOk = true;
        }

        private void toolStripButton13_Click(object sender, EventArgs e)
        {
             //判断是否是创建
            if (isCreate)
            {
                InputQuery iq = InputMsg.Show("保存","请输入此便签的便签标题！");
                if (iq.Dr == DialogResult.OK)
                {
                    if (string.IsNullOrEmpty(iq.InputMsg))
                    {
                        NoteMsg.Show("提示", "取消保存\r\n原因：标题不能为空");
                        return;
                    }
                    else
                    {
                        note.Title = iq.InputMsg;   
                    }
                }
                else
                {
                    NoteMsg.Show("提示","取消保存");
                    return;
                }

            }

            Query qu=isCreate? oper.SaveNewNote(note):oper.UpdateNote(note);
            if (qu.Querys)
            {
                Views.Message.NoteMsg.Show("提示","保存成功！");

            }else
            {
                Views.Message.NoteMsg.Show("提示",qu.Msg);

            }
        }

        public void ImpText()
        {
            OpenFileDialog sfd = new OpenFileDialog();
          //  sfd.FileName = note.NoteBlock.Username + "(" + note.Title + "[Txt])";
            sfd.Filter = "文本文件|*.*";
            if (sfd.ShowDialog() == DialogResult.OK)
            {
                FileStream fs = null;
                StreamReader sr = null; ;
                try
                {
                    Encoding en = GetFileEncodeType(sfd.FileName);//判断文本编码
                    fs = new FileStream(sfd.FileName, FileMode.OpenOrCreate, FileAccess.ReadWrite);

               //     FileInfo fi = new FileInfo(sfd.FileName);
                    
                    sr = new StreamReader(fs,en);
                    string text = sr.ReadToEnd();
                    int start = richTextBox1.Text.Length - 1;
                    richTextBox1.Text += text;
                    note.Msg.MsgText += text;
                    end();

                }
                catch
                {

                }
                finally
                {
                    if (sr != null)
                        sr.Close();
                    if (fs != null)
                        fs.Close();
                    
                }
                
            }
        }


        public System.Text.Encoding GetFileEncodeType(string filename)
     { 
         System.IO.FileStream fs = new System.IO.FileStream(filename, System.IO.FileMode.Open, System.IO.FileAccess.Read); 
        System.IO.BinaryReader br = new System.IO.BinaryReader(fs); 
        Byte[] buffer = br.ReadBytes(2); 
         if(buffer[0]>=0xEF) 
        { 
            if(buffer[0]==0xEF && buffer[1]==0xBB) 
             {
                    fs.Close();
                    br.Close();
                return System.Text.Encoding.UTF8; 
          } 
            else if(buffer[0]==0xFE && buffer[1]==0xFF) 
           {
                    fs.Close();
                    br.Close();
                    return System.Text.Encoding.BigEndianUnicode; 
          } 
           else if(buffer[0]==0xFF && buffer[1]==0xFE) 
            {
                    fs.Close();
                    br.Close();
                    return System.Text.Encoding.Unicode; 
           } 
            else
          {
                    fs.Close();
                    br.Close();
                    return System.Text.Encoding.Default; 
            } 
        } 
        else
        {
                fs.Close();
                br.Close();
                return System.Text.Encoding.Default; 
         } 
     }

        private void richTextBox1_Click(object sender, EventArgs e)
        {
            int point = richTextBox1.SelectionStart;
          lastStyle =  msgOper.getStyle(point);
            ///Console.WriteLine("S:{0} E:{1} P{2} Color:{3} S:{4}",lastStyle.StartIndex,lastStyle.EndIndex,point,lastStyle.MsgColor,note.Msg.Items.Count);
            nowStyle();
            
        }

        private void styleText_Click(object sender, EventArgs e)
        {

        }
    }
}
