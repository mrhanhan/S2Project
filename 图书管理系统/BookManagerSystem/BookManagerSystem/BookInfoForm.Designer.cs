namespace BookManagerSystem
{
    partial class BookInfoForm
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
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.combType = new System.Windows.Forms.ComboBox();
            this.datetime = new System.Windows.Forms.DateTimePicker();
            this.numPrice = new System.Windows.Forms.NumericUpDown();
            this.numPage = new System.Windows.Forms.NumericUpDown();
            this.txtPress = new System.Windows.Forms.TextBox();
            this.txtAutro = new System.Windows.Forms.TextBox();
            this.txtName = new System.Windows.Forms.TextBox();
            this.txtSum = new System.Windows.Forms.TextBox();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.button1 = new System.Windows.Forms.Button();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.label8 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.button2 = new System.Windows.Forms.Button();
            this.button3 = new System.Windows.Forms.Button();
            this.groupBox1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.numPrice)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.numPage)).BeginInit();
            this.groupBox2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.combType);
            this.groupBox1.Controls.Add(this.datetime);
            this.groupBox1.Controls.Add(this.numPrice);
            this.groupBox1.Controls.Add(this.numPage);
            this.groupBox1.Controls.Add(this.txtPress);
            this.groupBox1.Controls.Add(this.txtAutro);
            this.groupBox1.Controls.Add(this.txtName);
            this.groupBox1.Controls.Add(this.txtSum);
            this.groupBox1.Controls.Add(this.groupBox2);
            this.groupBox1.Controls.Add(this.label8);
            this.groupBox1.Controls.Add(this.label6);
            this.groupBox1.Controls.Add(this.label7);
            this.groupBox1.Controls.Add(this.label5);
            this.groupBox1.Controls.Add(this.label4);
            this.groupBox1.Controls.Add(this.label3);
            this.groupBox1.Controls.Add(this.label2);
            this.groupBox1.Controls.Add(this.label1);
            this.groupBox1.Dock = System.Windows.Forms.DockStyle.Top;
            this.groupBox1.Location = new System.Drawing.Point(0, 0);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(780, 417);
            this.groupBox1.TabIndex = 0;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "图书信息";
            // 
            // combType
            // 
            this.combType.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.combType.FormattingEnabled = true;
            this.combType.Location = new System.Drawing.Point(330, 54);
            this.combType.Name = "combType";
            this.combType.Size = new System.Drawing.Size(145, 23);
            this.combType.TabIndex = 6;
            // 
            // datetime
            // 
            this.datetime.Location = new System.Drawing.Point(120, 184);
            this.datetime.Name = "datetime";
            this.datetime.Size = new System.Drawing.Size(200, 25);
            this.datetime.TabIndex = 5;
            // 
            // numPrice
            // 
            this.numPrice.DecimalPlaces = 4;
            this.numPrice.Location = new System.Drawing.Point(331, 141);
            this.numPrice.Maximum = new decimal(new int[] {
            -1530494977,
            232830,
            0,
            0});
            this.numPrice.Name = "numPrice";
            this.numPrice.Size = new System.Drawing.Size(144, 25);
            this.numPrice.TabIndex = 4;
            // 
            // numPage
            // 
            this.numPage.Location = new System.Drawing.Point(90, 141);
            this.numPage.Maximum = new decimal(new int[] {
            1569325055,
            23283064,
            0,
            0});
            this.numPage.Name = "numPage";
            this.numPage.Size = new System.Drawing.Size(144, 25);
            this.numPage.TabIndex = 4;
            // 
            // txtPress
            // 
            this.txtPress.Location = new System.Drawing.Point(331, 98);
            this.txtPress.MaxLength = 15;
            this.txtPress.Name = "txtPress";
            this.txtPress.Size = new System.Drawing.Size(144, 25);
            this.txtPress.TabIndex = 3;
            // 
            // txtAutro
            // 
            this.txtAutro.Location = new System.Drawing.Point(90, 98);
            this.txtAutro.MaxLength = 15;
            this.txtAutro.Name = "txtAutro";
            this.txtAutro.Size = new System.Drawing.Size(144, 25);
            this.txtAutro.TabIndex = 3;
            // 
            // txtName
            // 
            this.txtName.Location = new System.Drawing.Point(90, 50);
            this.txtName.MaxLength = 15;
            this.txtName.Name = "txtName";
            this.txtName.Size = new System.Drawing.Size(144, 25);
            this.txtName.TabIndex = 3;
            // 
            // txtSum
            // 
            this.txtSum.Location = new System.Drawing.Point(90, 219);
            this.txtSum.MaxLength = 500;
            this.txtSum.Multiline = true;
            this.txtSum.Name = "txtSum";
            this.txtSum.Size = new System.Drawing.Size(392, 180);
            this.txtSum.TabIndex = 2;
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.button1);
            this.groupBox2.Controls.Add(this.pictureBox1);
            this.groupBox2.Location = new System.Drawing.Point(511, 54);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(251, 363);
            this.groupBox2.TabIndex = 1;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "图书封面";
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(0, 331);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(244, 31);
            this.button1.TabIndex = 1;
            this.button1.Text = "预览图片";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // pictureBox1
            // 
            this.pictureBox1.Location = new System.Drawing.Point(0, 24);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(249, 302);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox1.TabIndex = 0;
            this.pictureBox1.TabStop = false;
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(39, 184);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(75, 15);
            this.label8.TabIndex = 0;
            this.label8.Text = "出版时间:";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(39, 141);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(45, 15);
            this.label6.TabIndex = 0;
            this.label6.Text = "页数:";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(39, 219);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(45, 15);
            this.label7.TabIndex = 0;
            this.label7.Text = "简介:";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(249, 141);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(76, 15);
            this.label5.TabIndex = 0;
            this.label5.Text = "价格(元):";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(265, 98);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(60, 15);
            this.label4.TabIndex = 0;
            this.label4.Text = "出版社:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(39, 98);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(45, 15);
            this.label3.TabIndex = 0;
            this.label3.Text = "作者:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(250, 53);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(75, 15);
            this.label2.TabIndex = 0;
            this.label2.Text = "图书类别:";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(39, 53);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(45, 15);
            this.label1.TabIndex = 0;
            this.label1.Text = "书名:";
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(90, 452);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(244, 31);
            this.button2.TabIndex = 1;
            this.button2.Text = "预览图片";
            this.button2.UseVisualStyleBackColor = true;
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // button3
            // 
            this.button3.Location = new System.Drawing.Point(354, 452);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(244, 31);
            this.button3.TabIndex = 1;
            this.button3.Text = "取消";
            this.button3.UseVisualStyleBackColor = true;
            this.button3.Click += new System.EventHandler(this.button3_Click);
            // 
            // BookInfoForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(780, 495);
            this.Controls.Add(this.button3);
            this.Controls.Add(this.button2);
            this.Controls.Add(this.groupBox1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Name = "BookInfoForm";
            this.Text = "添加图书";
            this.Load += new System.EventHandler(this.BookInfoForm_Load);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.numPrice)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.numPage)).EndInit();
            this.groupBox2.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TextBox txtSum;
        private System.Windows.Forms.TextBox txtName;
        private System.Windows.Forms.DateTimePicker datetime;
        private System.Windows.Forms.NumericUpDown numPrice;
        private System.Windows.Forms.NumericUpDown numPage;
        private System.Windows.Forms.TextBox txtPress;
        private System.Windows.Forms.TextBox txtAutro;
        private System.Windows.Forms.ComboBox combType;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.Button button3;
    }
}