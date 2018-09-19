namespace NoteSystem.Views.Message
{
    partial class NoteMsg
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.label1 = new System.Windows.Forms.Label();
            this.button1 = new System.Windows.Forms.Button();
            this.button2 = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.timer1 = new System.Windows.Forms.Timer(this.components);
            this.MenuLayout.SuspendLayout();
            this.BodyLayou.SuspendLayout();
            this.SuspendLayout();
            // 
            // closebtn
            // 
            this.closebtn.FlatAppearance.BorderSize = 0;
            this.closebtn.Location = new System.Drawing.Point(1158, 0);
            // 
            // MenuLayout
            // 
            this.MenuLayout.Controls.Add(this.label1);
            this.MenuLayout.Size = new System.Drawing.Size(1203, 35);
            this.MenuLayout.Controls.SetChildIndex(this.closebtn, 0);
            this.MenuLayout.Controls.SetChildIndex(this.btnMaxShow, 0);
            this.MenuLayout.Controls.SetChildIndex(this.btnMinShow, 0);
            this.MenuLayout.Controls.SetChildIndex(this.label1, 0);
            // 
            // BodyLayou
            // 
            this.BodyLayou.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left)));
            this.BodyLayou.BackColor = System.Drawing.SystemColors.ButtonHighlight;
            this.BodyLayou.Controls.Add(this.label2);
            this.BodyLayou.Controls.Add(this.button2);
            this.BodyLayou.Controls.Add(this.button1);
            this.BodyLayou.Location = new System.Drawing.Point(7, 47);
            this.BodyLayou.Size = new System.Drawing.Size(523, 230);
            // 
            // btnMinShow
            // 
            this.btnMinShow.FlatAppearance.BorderSize = 0;
            this.btnMinShow.Location = new System.Drawing.Point(1062, 0);
            // 
            // btnMaxShow
            // 
            this.btnMaxShow.FlatAppearance.BorderSize = 0;
            this.btnMaxShow.Location = new System.Drawing.Point(1110, 0);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("宋体", 13.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.label1.ForeColor = System.Drawing.Color.White;
            this.label1.Location = new System.Drawing.Point(231, 8);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(88, 24);
            this.label1.TabIndex = 5;
            this.label1.Text = "label1";
            // 
            // button1
            // 
            this.button1.DialogResult = System.Windows.Forms.DialogResult.OK;
            this.button1.Location = new System.Drawing.Point(13, 167);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(177, 44);
            this.button1.TabIndex = 0;
            this.button1.Text = "确定";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // button2
            // 
            this.button2.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.button2.Location = new System.Drawing.Point(327, 167);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(177, 44);
            this.button2.TabIndex = 0;
            this.button2.Text = "取消";
            this.button2.UseVisualStyleBackColor = true;
            this.button2.Click += new System.EventHandler(this.button1_Click);
            // 
            // label2
            // 
            this.label2.Location = new System.Drawing.Point(10, 47);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(491, 117);
            this.label2.TabIndex = 1;
            this.label2.Text = "label2";
            this.label2.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // timer1
            // 
            this.timer1.Interval = 1000;
            this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
            // 
            // NoteMsg
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.DodgerBlue;
            this.ClientSize = new System.Drawing.Size(537, 284);
            this.Name = "NoteMsg";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "NoteMsg";
            this.MenuLayout.ResumeLayout(false);
            this.MenuLayout.PerformLayout();
            this.BodyLayou.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        public System.Windows.Forms.Button button1;
        public System.Windows.Forms.Button button2;
        public System.Windows.Forms.Timer timer1;
    }
}