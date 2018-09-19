using NoteSystem.Views.Component;
namespace NoteSystem
{
    partial class BaseNoteForm
    {
        /// <summary>
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 清理所有正在使用的资源。
        /// </summary>
        /// <param name="disposing">如果应释放托管资源，为 true；否则为 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region 组件设计器生成的代码

        /// <summary>
        /// 设计器支持所需的方法 - 不要修改
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            this.MenuLayout = new NoteSystem.Views.Component.LayoutControl();
            this.btnMinShow = new System.Windows.Forms.Button();
            this.btnMaxShow = new System.Windows.Forms.Button();
            this.closebtn = new System.Windows.Forms.Button();
            this.button3 = new System.Windows.Forms.Button();
            this.BodyLayou = new NoteSystem.Views.Component.LayoutControl();
            this.MenuLayout.SuspendLayout();
            this.SuspendLayout();
            // 
            // MenuLayout
            // 
            this.MenuLayout.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.MenuLayout.BackColor = System.Drawing.Color.DodgerBlue;
            this.MenuLayout.Controls.Add(this.btnMinShow);
            this.MenuLayout.Controls.Add(this.btnMaxShow);
            this.MenuLayout.Controls.Add(this.closebtn);
            this.MenuLayout.Controls.Add(this.button3);
            this.MenuLayout.Location = new System.Drawing.Point(2, 1);
            this.MenuLayout.Name = "MenuLayout";
            this.MenuLayout.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.MenuLayout.Size = new System.Drawing.Size(842, 34);
            this.MenuLayout.TabIndex = 0;
            this.MenuLayout.MouseDown += new System.Windows.Forms.MouseEventHandler(this.NoteForm_MouseDown);
            this.MenuLayout.MouseMove += new System.Windows.Forms.MouseEventHandler(this.NoteForm_MouseMove);
            this.MenuLayout.MouseUp += new System.Windows.Forms.MouseEventHandler(this.NoteForm_MouseUp);
            // 
            // btnMinShow
            // 
            this.btnMinShow.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.btnMinShow.BackColor = System.Drawing.Color.DodgerBlue;
            this.btnMinShow.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.btnMinShow.FlatAppearance.BorderSize = 0;
            this.btnMinShow.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnMinShow.Font = new System.Drawing.Font("宋体", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.btnMinShow.ForeColor = System.Drawing.Color.White;
            this.btnMinShow.Location = new System.Drawing.Point(701, 0);
            this.btnMinShow.Name = "btnMinShow";
            this.btnMinShow.Size = new System.Drawing.Size(42, 34);
            this.btnMinShow.TabIndex = 4;
            this.btnMinShow.Text = "-";
            this.btnMinShow.UseVisualStyleBackColor = false;
            this.btnMinShow.Click += new System.EventHandler(this.btnMinShow_Click);
            // 
            // btnMaxShow
            // 
            this.btnMaxShow.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.btnMaxShow.BackColor = System.Drawing.Color.DodgerBlue;
            this.btnMaxShow.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.btnMaxShow.FlatAppearance.BorderSize = 0;
            this.btnMaxShow.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnMaxShow.Font = new System.Drawing.Font("宋体", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.btnMaxShow.ForeColor = System.Drawing.Color.White;
            this.btnMaxShow.Location = new System.Drawing.Point(749, 0);
            this.btnMaxShow.Name = "btnMaxShow";
            this.btnMaxShow.Size = new System.Drawing.Size(42, 34);
            this.btnMaxShow.TabIndex = 4;
            this.btnMaxShow.Text = "口";
            this.btnMaxShow.UseVisualStyleBackColor = false;
            this.btnMaxShow.Click += new System.EventHandler(this.btnMaxShow_Click);
            // 
            // closebtn
            // 
            this.closebtn.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.closebtn.BackColor = System.Drawing.Color.DodgerBlue;
            this.closebtn.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.closebtn.FlatAppearance.BorderSize = 0;
            this.closebtn.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.closebtn.Font = new System.Drawing.Font("宋体", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.closebtn.ForeColor = System.Drawing.Color.White;
            this.closebtn.Location = new System.Drawing.Point(797, 0);
            this.closebtn.Name = "closebtn";
            this.closebtn.Size = new System.Drawing.Size(42, 34);
            this.closebtn.TabIndex = 4;
            this.closebtn.Text = "×";
            this.closebtn.UseVisualStyleBackColor = false;
            this.closebtn.Click += new System.EventHandler(this.closebtn_Click);
            // 
            // button3
            // 
            this.button3.Location = new System.Drawing.Point(1098, 0);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(0, 0);
            this.button3.TabIndex = 3;
            this.button3.UseVisualStyleBackColor = true;
            // 
            // BodyLayou
            // 
            this.BodyLayou.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.BodyLayou.BackColor = System.Drawing.SystemColors.Control;
            this.BodyLayou.Location = new System.Drawing.Point(2, 41);
            this.BodyLayou.Name = "BodyLayou";
            this.BodyLayou.Size = new System.Drawing.Size(842, 416);
            this.BodyLayou.TabIndex = 1;
            this.BodyLayou.MouseDown += new System.Windows.Forms.MouseEventHandler(this.NoteForm_MouseDown);
            this.BodyLayou.MouseMove += new System.Windows.Forms.MouseEventHandler(this.NoteForm_MouseMove);
            this.BodyLayou.MouseUp += new System.Windows.Forms.MouseEventHandler(this.NoteForm_MouseUp);
            // 
            // BaseNoteForm
            // 
            this.ClientSize = new System.Drawing.Size(845, 457);
            this.Controls.Add(this.BodyLayou);
            this.Controls.Add(this.MenuLayout);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "BaseNoteForm";
            this.MouseDown += new System.Windows.Forms.MouseEventHandler(this.NoteForm_MouseDown);
            this.MouseMove += new System.Windows.Forms.MouseEventHandler(this.NoteForm_MouseMove);
            this.MouseUp += new System.Windows.Forms.MouseEventHandler(this.NoteForm_MouseUp);
            this.Resize += new System.EventHandler(this.BaseNoteForm_Resize);
            this.MenuLayout.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion
        private System.Windows.Forms.Button button3;
        protected System.Windows.Forms.Button closebtn;
        protected LayoutControl MenuLayout;
        protected LayoutControl BodyLayou;
        protected System.Windows.Forms.Button btnMinShow;
        protected System.Windows.Forms.Button btnMaxShow;
    }
}
