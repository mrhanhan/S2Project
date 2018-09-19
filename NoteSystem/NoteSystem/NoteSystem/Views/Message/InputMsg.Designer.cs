namespace NoteSystem.Views.Message
{
    partial class InputMsg
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
            this.labTitle = new System.Windows.Forms.Label();
            this.textMsg = new System.Windows.Forms.TextBox();
            this.txtMsg = new System.Windows.Forms.Label();
            this.button1 = new System.Windows.Forms.Button();
            this.button2 = new System.Windows.Forms.Button();
            this.MenuLayout.SuspendLayout();
            this.BodyLayou.SuspendLayout();
            this.SuspendLayout();
            // 
            // closebtn
            // 
            this.closebtn.FlatAppearance.BorderSize = 0;
            this.closebtn.Location = new System.Drawing.Point(1124, 0);
            // 
            // MenuLayout
            // 
            this.MenuLayout.Controls.Add(this.labTitle);
            this.MenuLayout.Size = new System.Drawing.Size(1169, 48);
            this.MenuLayout.Controls.SetChildIndex(this.closebtn, 0);
            this.MenuLayout.Controls.SetChildIndex(this.btnMaxShow, 0);
            this.MenuLayout.Controls.SetChildIndex(this.btnMinShow, 0);
            this.MenuLayout.Controls.SetChildIndex(this.labTitle, 0);
            // 
            // BodyLayou
            // 
            this.BodyLayou.Controls.Add(this.button2);
            this.BodyLayou.Controls.Add(this.button1);
            this.BodyLayou.Controls.Add(this.txtMsg);
            this.BodyLayou.Controls.Add(this.textMsg);
            this.BodyLayou.Size = new System.Drawing.Size(563, 248);
            // 
            // btnMinShow
            // 
            this.btnMinShow.FlatAppearance.BorderSize = 0;
            this.btnMinShow.Location = new System.Drawing.Point(1028, 0);
            // 
            // btnMaxShow
            // 
            this.btnMaxShow.FlatAppearance.BorderSize = 0;
            this.btnMaxShow.Location = new System.Drawing.Point(1076, 0);
            // 
            // labTitle
            // 
            this.labTitle.AutoSize = true;
            this.labTitle.Font = new System.Drawing.Font("宋体", 13.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.labTitle.ForeColor = System.Drawing.SystemColors.Control;
            this.labTitle.Location = new System.Drawing.Point(243, 8);
            this.labTitle.Name = "labTitle";
            this.labTitle.Size = new System.Drawing.Size(88, 24);
            this.labTitle.TabIndex = 5;
            this.labTitle.Text = "label1";
            // 
            // textMsg
            // 
            this.textMsg.Location = new System.Drawing.Point(80, 128);
            this.textMsg.Name = "textMsg";
            this.textMsg.Size = new System.Drawing.Size(434, 25);
            this.textMsg.TabIndex = 0;
            // 
            // txtMsg
            // 
            this.txtMsg.Font = new System.Drawing.Font("宋体", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.txtMsg.ForeColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.txtMsg.Location = new System.Drawing.Point(80, 11);
            this.txtMsg.Name = "txtMsg";
            this.txtMsg.Size = new System.Drawing.Size(434, 91);
            this.txtMsg.TabIndex = 5;
            this.txtMsg.Text = "label1";
            // 
            // button1
            // 
            this.button1.DialogResult = System.Windows.Forms.DialogResult.OK;
            this.button1.Location = new System.Drawing.Point(80, 190);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(140, 34);
            this.button1.TabIndex = 6;
            this.button1.Text = "确认";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // button2
            // 
            this.button2.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.button2.Location = new System.Drawing.Point(374, 190);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(140, 34);
            this.button2.TabIndex = 6;
            this.button2.Text = "取消";
            this.button2.UseVisualStyleBackColor = true;
            // 
            // InputMsg
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(566, 289);
            this.Name = "InputMsg";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "InputMsg";
            this.MenuLayout.ResumeLayout(false);
            this.MenuLayout.PerformLayout();
            this.BodyLayou.ResumeLayout(false);
            this.BodyLayou.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Label labTitle;
        private System.Windows.Forms.TextBox textMsg;
        private System.Windows.Forms.Label txtMsg;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.Button button1;
    }
}