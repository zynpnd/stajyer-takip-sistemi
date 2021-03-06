package proje.staj.forms;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import proje.java.sql.MysqlConn;
import proje.staj.db.Birim;
import proje.staj.db.Bolum;
import proje.staj.db.Ogrenci;
import proje.staj.db.Staj;
import proje.staj.db.Universite;
import proje.staj.managers.AramaManager;
import proje.staj.managers.BirimManager;
import proje.staj.managers.BolumManager;
import proje.staj.managers.OgrenciManager;
import proje.staj.managers.UniversiteManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Zeynepnida
 */
public class OgrenciKaydet extends javax.swing.JPanel {

    private Ogrenci ogrenci;

    /**
     * Creates new form ogrenci
     */
    public OgrenciKaydet() throws SQLException {
        initComponents();
            
        kaydet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resim/ekle.png")));
        ara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resim/arama.png")));
        try {

            txt_ad.setVisible(false);
            txt_soyad.setVisible(false);
            txt_gun.setVisible(false);
            txt_baslama.setVisible(false);
            txt_birim.setVisible(false);
            txt_bitis.setVisible(false);
            txt_bolum.setVisible(false);
            txt_okul.setVisible(false);
            txtAd.setVisible(false);
            txtGun.setVisible(false);
            txtSoyad.setVisible(false);
            cmbBirim.setVisible(false);
            cmbBolum.setVisible(false);
            cmbUniversite.setVisible(false);
            dtBaslangicTarihi.setVisible(false);
            dtBitisTarihi.setVisible(false);
            kaydet.setVisible(false);

            ((DefaultComboBoxModel) this.cmbUniversite.getModel()).removeAllElements();
            UniversiteManager uniMan = new UniversiteManager();
            ArrayList<Universite> uniList = uniMan.getAllUni();
            for (Universite uni : uniList) {
                ((DefaultComboBoxModel) this.cmbUniversite.getModel()).addElement(uni);
            }

            ((DefaultComboBoxModel) this.cmbBolum.getModel()).removeAllElements();
            BolumManager bolMan = new BolumManager();
            ArrayList<Bolum> bolList = bolMan.getAllBolum();
            for (Bolum bol : bolList) {
                ((DefaultComboBoxModel) this.cmbBolum.getModel()).addElement(bol);
            }

            ((DefaultComboBoxModel) this.cmbBirim.getModel()).removeAllElements();
            BirimManager birMan = new BirimManager();
            ArrayList<Birim> birList = birMan.getAllBirim();
            for (Birim birim : birList) {
                ((DefaultComboBoxModel) this.cmbBirim.getModel()).addElement(birim);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Ogrenci.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_okul = new javax.swing.JLabel();
        txt_bolum = new javax.swing.JLabel();
        txt_baslama = new javax.swing.JLabel();
        kaydet = new javax.swing.JButton();
        txt_bitis = new javax.swing.JLabel();
        txt_gun = new javax.swing.JLabel();
        txtAd = new javax.swing.JTextField();
        txtTc = new javax.swing.JTextField();
        txtSoyad = new javax.swing.JTextField();
        txt_tc = new javax.swing.JLabel();
        txt_ad = new javax.swing.JLabel();
        txtGun = new javax.swing.JTextField();
        txt_soyad = new javax.swing.JLabel();
        cmbUniversite = new javax.swing.JComboBox<>();
        cmbBolum = new javax.swing.JComboBox<>();
        dtBaslangicTarihi = new org.jdesktop.swingx.JXDatePicker();
        dtBitisTarihi = new org.jdesktop.swingx.JXDatePicker();
        txt_birim = new javax.swing.JLabel();
        cmbBirim = new javax.swing.JComboBox<>();
        ara = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_okul.setText("OKUL");
        add(txt_okul, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 167, 20));

        txt_bolum.setText("BOLUM");
        add(txt_bolum, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 167, -1));

        txt_baslama.setText("STAJ BAŞLANGIÇ TARİHİ");
        add(txt_baslama, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 167, 30));

        kaydet.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zeynepnida\\Desktop\\stajj\\New Folder\\proje2\\resim\\ekle.png")); // NOI18N
        kaydet.setText("KAYDET");
        kaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kaydetActionPerformed(evt);
            }
        });
        add(kaydet, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 520, 175, 68));

        txt_bitis.setText("STAJ BİTİŞ TARİHİ");
        add(txt_bitis, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 130, 22));

        txt_gun.setText("STAJ GÜNÜ");
        add(txt_gun, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 140, 30));
        add(txtAd, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 320, -1));
        add(txtTc, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 320, -1));
        add(txtSoyad, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 320, -1));

        txt_tc.setText("TC");
        add(txt_tc, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 167, -1));

        txt_ad.setText("AD");
        add(txt_ad, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 150, 20));
        add(txtGun, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 320, 30));

        txt_soyad.setText("SOYAD");
        add(txt_soyad, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 167, -1));

        cmbUniversite.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Çukurova Üniversitesi", "Adana Alparslan Türkeş Bilim ve Teknoloji Üniversitesi", "Adıyaman Üniversitesi", "Afyonkarahisar Sağlık Bilimleri Üniversitesi", "Afyon Kocatepe Üniversitesi", "Aksaray Üniversitesi", "Amasya Üniversitesi", "Orta Doğu Teknik Üniversitesi", "Hacettepe Üniversitesi", "Gazi Üniversitesi", "Ankara Üniversitesi", "Ankara Yıldırım Beyazıt Üniversitesi", "Ankara Sosyal Bilimler Üniversitesi", "Ankara Hacı Bayram Veli Üniversitesi", "Ankara Müzik ve Güzel Sanatlar Üniversitesi", "Çankaya Üniversitesi", "Yüksek İhtisas Üniversitesi", "Ufuk Üniversitesi", "Türk Hava Kurumu Üniversitesi", "TOBB Ekonomi ve Teknoloji Üniversitesi", "TED Üniversitesi", "Ostim Teknik Üniversitesi", "Lokman Hekim Üniversitesi", "İhsan Doğramacı Bilkent Üniversitesi", "Başkent Üniversitesi", "Atılım Üniversitesi", "Ankara Medipol Üniversitesi", "Anka Teknoloji Üniversitesi", "Alanya Alaaddin Keykubat Üniversitesi", "Akdeniz Üniversitesi", "Antalya Bilim Üniversitesi", "Antalya Akev Üniversitesi", "Alanya Hamdullah Emin Paşa Üniversitesi", "Ardahan Üniversitesi", "Artvin Çoruh Üniversitesi", "Aydın Adnan Menderes Üniversitesi", "Ağrı İbrahim Çeçen Üniversitesi", "Bandırma Onyedi Eylül Üniversitesi", "Balıkesir Üniversitesi", "Bartın Üniversitesi", "Batman Üniversitesi", "Bayburt Üniversitesi", "Bilecik Şeyh Edebali Üniversitesi", "Bingöl Üniversitesi", "Bitlis Eren Üniversitesi", "Bolu Abant İzzet Baysal Üniversitesi", "Burdur Mehmet Akif Ersoy Üniversitesi", "Bursa Uludağ Üniversitesi", "Bursa Teknik Üniversitesi", "Pamukkale Üniversitesi", "Dicle Üniversitesi", "Düzce Üniversitesi", "Trakya Üniversitesi", "Fırat Üniversitesi", "Erzincan Binali Yıldırım Üniversitesi", "Erzurum Teknik Üniversitesi", "Atatürk Üniversitesi", "Eskişehir Teknik Üniversitesi", "Eskişehir Osmangazi Üniversitesi", "Anadolu Üniversitesi", "Gaziantep Üniversitesi", "Gaziantep Bilim ve Teknoloji Üniversitesi", "Sanko Üniversitesi", "Hasan Kalyoncu Üniversitesi", "Giresun Üniversitesi", "Gümüşhane Üniversitesi", "Hakkari Üniversitesi", "İskenderun Teknik Üniversitesi", "Hatay Mustafa Kemal Üniversitesi", "Süleyman Demirel Üniversitesi", "Isparta Uygulamalı Bilimler Üniversitesi", "Iğdır Üniversitesi", "Yıldız Teknik Üniversitesi", "Türkiye Uluslararası İslam, Bilim ve Teknoloji Üniversitesi", "Türk-Alman Üniversitesi", "Sağlık Bilimleri Üniversitesi", "Mimar Sinan Güzel Sanatlar Üniversitesi", "Millî Savunma Üniversitesi (Askerî)", "Marmara Üniversitesi", "İstanbul Üniversitesi Cerrahpaşa", "İstanbul Üniversitesi", "İstanbul Teknik Üniversitesi", "İstanbul Medeniyet Üniversitesi", "Galatasaray Üniversitesi", "Boğaziçi Üniversitesi", "Üsküdar Üniversitesi", "Özyeğin Üniversitesi", "Yeni Yüzyıl Üniversitesi", "Yeditepe Üniversitesi", "Semerkand Bilim ve Medeniyet Üniversitesi", "Sabancı Üniversitesi", "Piri Reis Üniversitesi", "Nişantaşı Üniversitesi", "MEF Üniversitesi", "Maltepe Üniversitesi", "Koç Üniversitesi", "Kadir Has Üniversitesi", "İstinye Üniversitesi", "İstanbul Şehir Üniversitesi", "İstanbul Ticaret Üniversitesi", "İstanbul Sabahattin Zaim Üniversitesi", "İstanbul Rumeli Üniversitesi", "İstanbul Okan Üniversitesi", "İstanbul Medipol Üniversitesi", "İstanbul Kültür Üniversitesi", "İstanbul Kent Üniversitesi", "İstanbul Gelişim Üniversitesi", "İstanbul Gedik Üniversitesi", "İstanbul Esenyurt Üniversitesi", "İstanbul Bilim Üniversitesi", "İstanbul Bilgi Üniversitesi", "İstanbul Beykoz Üniversitesi", "İstanbul Ayvansaray Üniversitesi", "İstanbul Aydın Üniversitesi", "İstanbul Atlas Üniversitesi", "İstanbul Arel Üniversitesi", "İstanbul Altınbaş Üniversitesi", "İstanbul 29 Mayıs Üniversitesi", "İbn Haldun Üniversitesi", "Işık Üniversitesi", "Haliç Üniversitesi", "Fatih Sultan Mehmet Üniversitesi", "Doğuş Üniversitesi", "Biruni Üniversitesi", "Bezmialem Vakıf Üniversitesi", "Beykent Üniversitesi", "Bahçeşehir Üniversitesi", "Acıbadem Üniversitesi", "İzmir Yüksek Teknoloji Enstitüsü", "İzmir Kâtip Çelebi Üniversitesi", "İzmir Demokrasi Üniversitesi", "İzmir Bakırçay Üniversitesi", "Ege Üniversitesi", "Dokuz Eylül Üniversitesi", "Yaşar Üniversitesi", "İzmir Tınaztepe Üniversitesi", "İzmir Ekonomi Üniversitesi", "Kahramanmaraş Sütçü İmam Üniversitesi", "Kahramanmaraş İstiklal Üniversitesi", "Karabük Üniversitesi", "Karamanoğlu Mehmetbey Üniversitesi", "Kafkas Üniversitesi", "Kastamonu Üniversitesi", "Kayseri Üniversitesi", "Erciyes Üniversitesi", "Abdullah Gül Üniversitesi", "Nuh Naci Yazgan Üniversitesi", "Kilis 7 Aralık Üniversitesi", "Kocaeli Üniversitesi", "Gebze Teknik Üniversitesi", "Selçuk Üniversitesi", "Necmettin Erbakan Üniversitesi", "Konya Teknik Üniversitesi", "KTO Karatay Üniversitesi", "Konya Gıda ve Tarım Üniversitesi", "Kütahya Sağlık Bilimleri Üniversitesi", "Kütahya Dumlupınar Üniversitesi", "Kırklareli Üniversitesi", "Kırıkkale Üniversitesi", "Kırşehir Ahi Evran Üniversitesi", "Malatya Turgut Özal Üniversitesi", "İnönü Üniversitesi", "Manisa Celal Bayar Üniversitesi", "Mardin Artuklu Üniversitesi", "Tarsus Üniversitesi", "Mersin Üniversitesi", "Çağ Üniversitesi", "Toros Üniversitesi", "Muğla Sıtkı Koçman Üniversitesi", "Muş Alparslan Üniversitesi", "Nevşehir Hacı Bektaş Veli Üniversitesi", "Kapadokya Üniversitesi", "Niğde Ömer Halisdemir Üniversitesi", "Ordu Üniversitesi", "Osmaniye Korkut Ata Üniversitesi", "Recep Tayyip Erdoğan Üniversitesi", "Sakarya Üniversitesi", "Sakarya Uygulamalı Bilimler Üniversitesi", "Samsun Üniversitesi", "Ondokuz Mayıs Üniversitesi", "Siirt Üniversitesi", "Sinop Üniversitesi", "Sivas Cumhuriyet Üniversitesi", "Sivas Bilim ve Teknoloji Üniversitesi", "Tekirdağ Namık Kemal Üniversitesi", "Tokat Gaziosmanpaşa Üniversitesi", "Trabzon Üniversitesi", "Karadeniz Teknik Üniversitesi", "Avrasya Üniversitesi", "Munzur Üniversitesi", "Uşak Üniversitesi", "Van Yüzüncü Yıl Üniversitesi", "Yalova Üniversitesi", "Yozgat Bozok Üniversitesi", "Zonguldak Bülent Ecevit Üniversitesi", "Çanakkale Onsekiz Mart Üniversitesi", "Çankırı Karatekin Üniversitesi", "Hitit Üniversitesi", "Harran Üniversitesi", "Şırnak Üniversitesi", " " }));
        add(cmbUniversite, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 320, -1));

        cmbBolum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Adli Bilimler", "Adli Bilişim Mühendisliği", "Ağaç İşleri Endüstri Mühendisliği", "Aile ve Tüketici Bilimleri", "Aktüerya", "Aktüerya Bilimleri", "Aktüerya ve Risk Yönetimi", "Alman Dili ve Edebiyatı", "Almanca Öğretmenliği", "Amerikan Kültürü ve Edebiyatı", "Animasyon", "Animasyon ve Oyun Tasarımı", "Antrenörlük Eğitimi", "Antropoloji", "Arap Dili ve Edebiyatı", "Arapça Öğretmenliği", "Arkeoloji", "Arkeoloji ve Sanat Tarihi", "Arnavut Dili ve Edebiyatı", "Astronomi ve Astrofizik", "Astronomi ve Uzay Bilimleri", "Avrupa Birliği İlişkileri", "Azerbaycan Dili Öğretmenliği", "Azerbaycan Türkçesi ve Edebiyatı", "Bahçe Bitkileri", "Bahçe Bitkileri Üretimi ve Pazarlaması", "Bahçe ve Tarla Bitkileri", "Balıkçılık Teknolojisi", "Balıkçılık Teknolojisi Mühendisliği", "Bankacılık", "Bankacılık ve Finans", "Bankacılık ve Sigortacılık", "Basım Teknolojileri (Yüksekokul)", "Basın ve Yayın", "Beden Eğitimi ve Spor Öğretmenliği", "Beslenme ve Diyetetik", "Bilgi ve Belge Yönetimi", "Bilgisayar Bilimleri", "Bilgisayar Mühendisliği", "Bilgisayar Teknolojisi ve Bilişim Sistemleri (Yüksekokul)", "Bilgisayar ve Öğretim Teknolojileri Öğretmenliği", "Bilgisayar ve Yazılım Mühendisliği", "Bilgisayar-Enformatik", "Bilim Tarihi", "Bilişim Sistemleri Mühendisliği", "Bilişim Sistemleri ve Teknolojileri", "Bitki Koruma", "Bitkisel Üretim ve Teknolojileri", "Biyoenformatik ve Genetik", "Biyokimya", "Biyoloji", "Biyoloji Öğretmenliği", "Biyomedikal Mühendisliği", "Biyomühendislik", "Biyosistem Mühendisliği", "Biyoteknoloji", "Biyoteknoloji ve Moleküler Biyoloji", "Boşnak Dili ve Edebiyatı", "Bulgar Dili ve Edebiyatı", "Canlandırma Filmi Tasarım ve Yönetimi", "Cevher Hazırlama Mühendisliği", "Coğrafya", "Coğrafya Öğretmenliği", "Çağdaş Türk Lehçeleri ve Edebiyatları", "Çağdaş Yunan Dili ve Edebiyatı", "Çalışma Ekonomisi ve Endüstri İlişkileri", "Çerkez Dili ve Edebiyatı", "Çeviribilim", "Çevre Mühendisliği", "Çin Dili ve Edebiyatı", "Çizgi Film ve Animasyon", "Çocuk Gelişimi", "Deniz İşletmeciliği ve Yönetimi", "Deniz Ulaştırma İşletme Mühendisliği", "Denizcilik İşletmeleri Yönetimi", "Deri Mühendisliği", "Dijital Oyun Tasarımı", "Dil ve Konuşma Terapisi", "Dilbilim", "Dilbilimi", "Dini İlimler", "Diş Hekimliği", "Ebelik", "Eczacılık", "Ekonometri", "Ekonomi", "Ekonomi ve Finans", "El Sanatları", "El Sanatları Tasarımı ve Üretimi", "Elektrik Mühendisliği", "Elektrik-Elektronik Mühendisliği", "Elektronik Mühendisliği", "Elektronik Ticaret ve Teknoloji Yönetimi", "Elektronik ve Haberleşme Mühendisliği", "Endüstri Mühendisliği", "Endüstri Mühendisliği Programları", "Endüstri Ürünleri Tasarımı", "Endüstri ve Sistem Mühendisliği", "Endüstriyel Tasarım", "Endüstriyel Tasarım Mühendisliği", "Enerji Mühendisliği", "Enerji Sistemleri Mühendisliği", "Enerji Yönetimi", "Ergoterapi", "Ermeni Dili ve Edebiyatı", "Ermeni Dili ve Kültürü", "Eski Yunan Dili ve Edebiyatı", "Eşit Ağırlıklı Programlar", "Fars Dili ve Edebiyatı", "Felsefe", "Felsefe Grubu Öğretmenliği", "Fen Bilgisi Öğretmenliği", "Film Tasarım ve Yazarlık", "Film Tasarım ve Yönetmenliği", "Film Tasarımı", "Finans ve Bankacılık", " ", "Fizik", "Fizik Mühendisliği", "Fizik Öğretmenliği", "Fizyoterapi ve Rehabilitasyon", "Fotoğraf", "Fotoğraf ve Video", "Fransız Dili ve Edebiyatı", "Fransızca Öğretmenliği", "Gastronomi", "Gastronomi ve Mutfak Sanatları", "Gayrimenkul Geliştirme ve Yönetimi", "Gayrimenkul ve Varlık Değerleme", "Gazetecilik", "Geleneksel Türk Sanatları", "Gemi İnşaatı ve Gemi Makineleri Mühendisliği", "Gemi Makineleri İşletme Mühendisliği", "Gemi ve Deniz Teknolojisi Mühendisliği", "Gemi ve Yat Tasarımı", "Genetik ve Biyomühendislik", "Genetik ve Yaşam Bilimleri Programları", "Geomatik Mühendisliği", "Gerontoloji", "Gıda Mühendisliği", "Gıda Teknolojisi", "Girişimcilik", "Görsel İletişim", "Görsel İletişim Tasarımı", "Görsel Sanatlar", "Görsel Sanatlar ve Görsel İletişim Tasarımı", "Görsel Sanatlar ve İletişim Tasarımı", "Grafik Tasarım", "Gümrük İşletme ", "Gürcü Dili ve Edebiyatı", "Güverte ", "Halkbilim", "Halkla İlişkiler", "Halkla İlişkiler ve Reklamcılık", "Halkla İlişkiler ve Tanıtım", "Harita Mühendisliği", "Havacılık Elektrik ve Elektroniği", "Havacılık ve Uzay Mühendisliği", "Havacılık Yönetimi", "Hayvansal Üretim (Yüksekokul)", "Hidrojeoloji Mühendisliği", "Hindoloji", "Hititoloji", "Hukuk", "Hungaroloji", "İbrani Dili ve Edebiyatı", "İç Mimarlık", "İç Mimarlık ve Çevre Tasarımı", "İktisadi ve İdari Bilimler Programları", "İktisadi ve İdari Programlar", "İktisat", "İlahiyat", "İletişim", "İletişim Bilimleri", "İletişim Sanatları", "İletişim Tasarımı", "İletişim Tasarımı ve Medya", "İletişim Tasarımı ve Yönetimi", "İletişim ve Tasarım", "İlköğretim Matematik Öğretmenliği", "İmalat Mühendisliği", "İngiliz Dil Bilimi", "İngiliz Dili ve Edebiyatı", "İngiliz Dili ve Karşılaştırmalı Edebiyat", "İngiliz ve Rus Dilleri ve Edebiyatları", "İngilizce Öğretmenliği", "İnsan Kaynakları Yönetimi", "İnsan ve Toplum Bilimleri", "İnşaat Mühendisliği", "İslam Ekonomisi ve Finans", "İslam Bilimleri", "İslam ve Din Bilimleri", "İslami İlimler", "İspanyol Dili ve Edebiyatı", "İstatistik", "İstatistik ve Bilgisayar Bilimleri", "İş Sağlığı ve Güvenliği", "İşletme", "İşletme Bilgi Yönetimi (Yüksekokul)", "İşletme Enformatiği", "İşletme Mühendisliği", "İşletme Yönetimi", "İşletme-Ekonomi", "İtalyan Dili ve Edebiyatı", "Japon Dili ve Edebiyatı", "Japonca Öğretmenliği", "Jeofizik Mühendisliği", "Jeoloji Mühendisliği", "Kamu Yönetimi", "Kanatlı Hayvan Yetiştiriciliği", "Karşılaştırmalı Edebiyat", "Kentsel Tasarım ve Peyzaj Mimarlığı", "Kimya", "Kimya Mühendisliği", "Kimya Mühendisliği ve Uygulamalı Kimya", "Kimya Öğretmenliği", "Kimya ve Süreç Mühendisliği", "Kimya-Biyoloji Mühendisliği", "Klasik Arkeoloji", "Konaklama İşletmeciliği", "Konaklama ve Turizm İşletmeciliği (Yüksekokul)", "Kontrol ve Otomasyon Mühendisliği", "Kore Dili ve Edebiyatı", "Kurgu-Ses ve Görüntü Yönetimi", "Kuyumculuk ve Mücevher Tasarımı", "Kültür Varlıklarını Koruma ve Onarım", "Kültür ve İletişim Bilimleri", "Küresel Siyaset ve Uluslararası İlişkiler", "Kürt Dili ve Edebiyatı", "Latin Dili ve Edebiyatı", "Leh Dili ve Edebiyatı", "Lif ve Polimer Mühendisliği", "Lojistik (Yüksekokul)", "Lojistik ve Taşımacılık (Yüksekokul)", "Lojistik Yönetimi", "Maden Mühendisliği", "Makine Mühendisliği", "Makine ve İmalat Mühendisliği", "Maliye", "Malzeme Bilimi ve Mühendisliği", "Malzeme Bilimi ve Nanoteknoloji Mühendisliği", "Malzeme Bilimi ve Teknolojileri", "Malzeme Mühendisliği", "Matematik", "Matematik Mühendisliği", "Matematik Öğretmenliği", "Matematik ve Bilgisayar Bilimleri", "Matematik-Bilgisayar", "Medya ve Görsel Sanatlar", "Medya ve İletişim", "Mekatronik Mühendisliği", "Mekatronik Sistemler Mühendisliği", "Metalurji ve Malzeme Mühendisliği", "Meteoroloji Mühendisliği", "Mimarlık", "Moda Tasarımı", "Moda ve Tekstil Tasarımı", "Moleküler Biyoloji ve Genetik", "Moleküler Biyoteknoloji", "Muhasebe (Yüksekokul)", "Muhasebe Bilgi Sistemleri (Yüksekokul)", "Muhasebe ve Denetim", "Muhasebe ve Finans Yönetimi ", "Mutfak Sanatları ve Yönetimi", "Mühendislik Programları", "Mühendislik ve Doğa Bilimleri Programları", "Mütercim-Tercümanlık", "Müzecilik", "Nanobilim ve Nanoteknoloji", "Nanoteknoloji Mühendisliği", "Nükleer Enerji Mühendisliği", "Odyoloji", "Okul Öncesi Öğretmenliği", "Optik ve Akustik Mühendisliği", "Organik Tarım İşletmeciliği (Yüksekokul)", "Orman Endüstrisi Mühendisliği", "Orman Mühendisliği", "Ortez-Protez ", "Otel Yöneticiliği (Yüksekokul)", "Otomotiv Mühendisliği", "Özel Eğitim Öğretmenliği", "Pazarlama", "Perfüzyon", "Petrol ve Doğalgaz Mühendisliği", "Peyzaj Mimarlığı", "Pilotaj", "Polimer Mühendisliği", "Polonya Dili ve Kültürü", "Protohistorya ve Ön Asya Arkeolojisi", "Psikoloji", "Radyo ve Televizyon", "Radyo, Televizyon ve Sinema", "Raylı Sistemler Mühendisliği", "PDR Rehberlik ve Psikolojik Danışmanlık", "Reklam Tasarımı ve İletişimi", "Reklamcılık", "Reklamcılık ve Halkla İlişkiler", "Rekreasyon", "Rekreasyon Yönetimi", "Restorasyon ve Konservasyon (Yüksekokul)", "Rus Dili Öğretmenliği", "Rus Dili ve Edebiyatı", "Rus Dili ve Edebiyatı Öğretmenliği", "Rus ve İngiliz Dilleri ve Edebiyatı", "Sağlık Yönetimi", "Sanat Tarihi", "Sanat ve Kültür Yönetimi", "Sanat ve Sosyal Bilimler Programları", "Sanat Yönetimi", "Sermaye Piyasaları ve Portföy Yönetimi (Yüksekokul)", "Sermaye Piyasası (Yüksekokul)", "Seyahat İşletmeciliği", "Seyahat İşletmeciliği ve Turizm Rehberliği", "Sınıf Öğretmenliği", "Sigortacılık (Yüksekokul)", "Sigortacılık ve Aktüerya Bilimleri", "Sigortacılık ve Risk Yönetimi", "Sigortacılık ve Sosyal Güvenlik", "Sinema ve Dijital Medya", "Sinema ve Televizyon", "Sinoloji", "Siyasal Bilimler", "Siyaset Bilimi", "Siyaset Bilimi ve Kamu Yönetimi", "Siyaset Bilimi ve Uluslararası İlişkiler", "Sosyal ve Siyasal Bilimler", "Sosyal Bilgiler Öğretmenliği", "Sosyal Hizmet", "Sosyoloji", "Spor Yöneticiliği", "Su Bilimleri ve Mühendisliği", "Su Ürünleri Mühendisliği", "Sümeroloji", "Süryani Dili ve Edebiyatı", "Süt Teknolojisi", "Şehir ve Bölge Planlama", "Takı Tasarımı", "Tapu Kadastro (Yüksekokul)", "Tarım Ekonomisi", "Tarım Makineleri ve Teknolojileri Mühendisliği", "Tarımsal Biyoteknoloji", "Tarımsal Genetik Mühendisliği", "Tarımsal Yapılar ve Sulama", "Tarih", "Tarih Öğretmenliği", "Tarih Öncesi Arkeolojisi", "Tarla Bitkileri", "Taşınabilir Kültür Varlıklarını Koruma ve Onarım", "Teknoloji ve Bilgi Yönetimi", "Tekstil Mühendisliği", "Tekstil Tasarımı", "Tekstil ve Moda Tasarımı", "Televizyon Haberciliği ve Programcılığı", "Tıp Mühendisliği", "Tiyatro Eleştirmenliği ve Dramaturji", "Toprak Bilimi ve Bitki Besleme", "Turizm İşletmeciliği", "Turizm İşletmeciliği ve Otelcilik (Yüksekokul)", "Turizm Rehberliği", "Turizm ve Otel İşletmeciliği", "Turizm ve Otelcilik", "Türk Dili ve Edebiyatı", "Türk Dili ve Edebiyatı Öğretmenliği", "Türk Halkbilimi", "Türk İslam Arkeolojisi", "Türkçe Öğretmenliği", "Türkoloji", "Tütün Eksperliği (Yüksekokul)", "Uçak Elektrik-Elektronik", "Uçak Gövde-Motor Bakım", "Uçak Mühendisliği", "Uçak ve Uzay Mühendisliği", "Ulaştırma Mühendisliği", "Ulaştırma ve Lojistik", "Uluslararası Finans", "Uluslararası Finans ve Bankacılık", "Uluslararası Girişimcilik", "Uluslararası İlişkiler", "Uluslararası İşletme Yönetimi", "Uluslararası İşletmecilik", "Uluslararası İşletmecilik ve Ticaret", "Uluslararası Lojistik ve Taşımacılık", "Uluslararası Lojistik Yönetimi", "Uluslararası Ticaret", "Uluslararası Ticaret ve Finans", "Uluslararası Ticaret ve İşletmecilik", "Uluslararası Ticaret ve Lojistik", "Uluslararası Ticaret ve Lojistik Yönetimi", "Uzay Bilimleri ve Teknolojileri", "Uzay Mühendisliği", "Yaban Hayatı Ekolojisi ve Yönetimi", "Yazılım Mühendisliği", "Yeni Medya", "Yeni Medya ve Gazetecilik", "Yeni Medya ve İletişim", "Yer Bilimleri Mühendisliği Programları", "Yerel Yönetimler", "Yönetim Bilimleri Programları", "Yönetim Bilişim Sistemleri", "Ziraat Mühendisliği Programları", "Zootekni", " " }));
        add(cmbBolum, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 320, -1));
        add(dtBaslangicTarihi, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 320, -1));
        add(dtBitisTarihi, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 320, -1));

        txt_birim.setText("BİRİM ADI");
        add(txt_birim, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 100, 30));

        cmbBirim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bilgi İşl. Da. Bşk.", "Abone İşl. Da. Bşk.", "İns. Kay. Ve Eğitim Da. Bşk", "İşletmeler Da. Bşk.", "Su Tes. Da. Bşk.", "Arıtma Tes. Da. Bşk.", "Yat. Ve İnş. Da. Bşk." }));
        add(cmbBirim, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, 320, 30));

        ara.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zeynepnida\\Desktop\\stajj\\New Folder\\proje2\\resim\\arama.png")); // NOI18N
        ara.setText("Ara");
        ara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                araActionPerformed(evt);
            }
        });
        add(ara, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 130, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void kaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kaydetActionPerformed
        try {

            OgrenciManager ogrenciManager = new OgrenciManager();
            String TC = txtTc.getText();
            String ad = txtAd.getText();
            String soyad = txtSoyad.getText();
            int gun = Integer.parseInt(txtGun.getText());
            Universite universite = (Universite) cmbUniversite.getSelectedItem();
            Bolum bolum = (Bolum) cmbBolum.getSelectedItem();
            Date baslangicTarihi = this.dtBaslangicTarihi.getDate();
            Date bitisTarihi = this.dtBitisTarihi.getDate();

            Birim birim = (Birim) cmbBirim.getSelectedItem();
            if (this.ogrenci == null) {

                this.ogrenci = new Ogrenci();
                this.ogrenci.setTc(Long.parseLong(TC));
                this.ogrenci.setAd(ad);
                this.ogrenci.setSoyad(soyad);
                this.ogrenci.setOkul(universite);
                this.ogrenci.setBolum(bolum);

                ogrenciManager.ekleOgrenci(this.ogrenci);
            }
            Staj staj = new Staj();
            staj.setOgrenci(this.ogrenci);
            staj.setBaslama_tarihi(baslangicTarihi);
            staj.setBitis_tarihi(bitisTarihi);
            staj.setStaj_gun(gun);
            staj.setBirim(birim);
            ogrenciManager.ekleuser(staj);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Hata Oluştu", "Hata", JOptionPane.ERROR_MESSAGE);
        }

        JOptionPane.showMessageDialog(this, "Öğrenci başarılı bir şekilde kaydedildi.");
        // TODO add your handling code here:
    }//GEN-LAST:event_kaydetActionPerformed

    private void araActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_araActionPerformed

        AramaManager aramaManager = new AramaManager();
        String tc = txtTc.getText();
        try {
            ogrenci = aramaManager.arauser(Integer.parseInt(tc));
            txt_ad.setVisible(true);
            txt_soyad.setVisible(true);
            txt_gun.setVisible(true);
            txt_baslama.setVisible(true);
            txt_birim.setVisible(true);
            txt_bitis.setVisible(true);
            txt_bolum.setVisible(true);
            txt_okul.setVisible(true);
            txtAd.setVisible(true);
            txtGun.setVisible(true);
            txtSoyad.setVisible(true);
            cmbBirim.setVisible(true);
            cmbBolum.setVisible(true);
            cmbUniversite.setVisible(true);
            dtBaslangicTarihi.setVisible(true);
            dtBitisTarihi.setVisible(true);
            kaydet.setVisible(true);
            ara.setVisible(false);

            if (ogrenci != null) {
                txtAd.setText(ogrenci.getAd());
                txtSoyad.setText(ogrenci.getSoyad());
                ((DefaultComboBoxModel) cmbUniversite.getModel()).setSelectedItem(ogrenci.getOkul());
                cmbBolum.setSelectedItem(ogrenci.getBolum());

            }
// TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(Ogrenci.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_araActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ara;
    private javax.swing.JComboBox<String> cmbBirim;
    private javax.swing.JComboBox<String> cmbBolum;
    private javax.swing.JComboBox<String> cmbUniversite;
    private org.jdesktop.swingx.JXDatePicker dtBaslangicTarihi;
    private org.jdesktop.swingx.JXDatePicker dtBitisTarihi;
    private javax.swing.JButton kaydet;
    private javax.swing.JTextField txtAd;
    private javax.swing.JTextField txtGun;
    private javax.swing.JTextField txtSoyad;
    private javax.swing.JTextField txtTc;
    private javax.swing.JLabel txt_ad;
    private javax.swing.JLabel txt_baslama;
    private javax.swing.JLabel txt_birim;
    private javax.swing.JLabel txt_bitis;
    private javax.swing.JLabel txt_bolum;
    private javax.swing.JLabel txt_gun;
    private javax.swing.JLabel txt_okul;
    private javax.swing.JLabel txt_soyad;
    private javax.swing.JLabel txt_tc;
    // End of variables declaration//GEN-END:variables

}