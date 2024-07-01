package com.alifalpian.expertsystem.view.diagnose

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alifalpian.expertsystem.R
import com.alifalpian.expertsystem.databinding.FragmentDiagnoseBinding
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.util.*

class DiagnoseFragment : Fragment() {
    private var _binding: FragmentDiagnoseBinding? = null
    private val binding get() = _binding!!

    //diubah
    private lateinit var PenglihatanTerasaKabur: CheckBox
    private lateinit var MataBerair: CheckBox
    private lateinit var MataBengkak: CheckBox
    private lateinit var MataTerasaPerih: CheckBox
    private lateinit var MataTerasaMengganjal: CheckBox
    private lateinit var PenglihatanSilau: CheckBox
    private lateinit var TerlihatLingkaranCahaya: CheckBox
    private lateinit var PenglihatanObjekGanda: CheckBox
    private lateinit var MataBerwarnaMerah: CheckBox
    private lateinit var MataTerasaGatal: CheckBox
    private lateinit var MataTerasaPanas: CheckBox
    private lateinit var SakitKepala: CheckBox
    private lateinit var MataTerasaSakit: CheckBox
    private lateinit var MataMeradang: CheckBox
    private lateinit var MataNyeriHebat: CheckBox
    private lateinit var MataTerasaNyeri: CheckBox
    private lateinit var KelainanPadaPupilMata: CheckBox
    private lateinit var MataLelah: CheckBox
    private lateinit var SeringMengedipkanMata: CheckBox
    private lateinit var PekaTerhadapCahaya: CheckBox
    private lateinit var PenglihatanDekatTerasaKabur: CheckBox
    private lateinit var TekananBolaMataMeningkat: CheckBox
    private lateinit var PenglihatanObjekJauhKurangJelas: CheckBox
    private lateinit var LemakMenutupiKornea: CheckBox
    private lateinit var MenyipitkanMata: CheckBox
    private lateinit var SumberCahayaBerwarnaPelangi: CheckBox
    private lateinit var MataTegang: CheckBox
    private lateinit var TerlihatBayanganGarisHitam: CheckBox

    private lateinit var btnDiagnosa : Button

    //daftar penyakit
    // diubah
    private val P01 = "Katarak"
    private val P02 = "Dry eye"
    private val P03 = "Glaukoma"
    private val P04 = "Keratitis"
    private val P05 = "Myopia"
    private val P06 = "Pterygium"
    private val P07 = "Hypermetropi"
    private val P08 = "Astigmatisma"


    // Membuat tampilan fragment dengan meng-inflate layout FragmentDiagnoseBinding.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDiagnoseBinding.inflate(inflater, container, false)
        val view = binding.root

        // Inisialisasi Firebase Realtime Database
        val database = FirebaseDatabase.getInstance()
        val diagnosaRef = database.reference.child("diagnose")

        // Inisialisasi elemen-elemen tampilan checkbox dan button di layout.
        //diubah
        PenglihatanTerasaKabur = binding.G01
        MataBerair = binding.G02
        MataBengkak = binding.G03
        MataTerasaPerih = binding.G04
        MataTerasaMengganjal = binding.G05
        PenglihatanSilau = binding.G06
        TerlihatLingkaranCahaya = binding.G07
        PenglihatanObjekGanda = binding.G08
        MataBerwarnaMerah = binding.G09
        MataTerasaGatal = binding.G10
        MataTerasaPanas = binding.G11
        SakitKepala = binding.G12
        MataTerasaSakit = binding.G13
        MataMeradang = binding.G14
        MataNyeriHebat = binding.G15
        MataTerasaNyeri = binding.G16
        KelainanPadaPupilMata = binding.G17
        MataLelah = binding.G18
        SeringMengedipkanMata = binding.G19
        PekaTerhadapCahaya = binding.G20
        PenglihatanDekatTerasaKabur = binding.G21
        TekananBolaMataMeningkat = binding.G22
        PenglihatanObjekJauhKurangJelas = binding.G23
        LemakMenutupiKornea = binding.G24
        MenyipitkanMata = binding.G25
        SumberCahayaBerwarnaPelangi = binding.G26
        MataTegang = binding.G27
        TerlihatBayanganGarisHitam = binding.G28

        btnDiagnosa = binding.btnDiagnosa

        // Aksi ketika tombol Diagnosa ditekan.
        btnDiagnosa.setOnClickListener {
            var namaPenyakit = ""

            // Proses pengecekan gejala pada checkbox dan menambahkan nama penyakit ke variabel namaPenyakit.
            if (PenglihatanTerasaKabur.isChecked && PenglihatanObjekGanda.isChecked && MataTerasaNyeri.isChecked && TerlihatBayanganGarisHitam.isChecked) {
                namaPenyakit += "$P01, "
                Log.d("Check", namaPenyakit)
            }
            if (MataTerasaMengganjal.isChecked && PekaTerhadapCahaya.isChecked) {
                namaPenyakit += "$P02, "
                Log.d("Check", namaPenyakit)

            }
            if (MataTerasaSakit.isChecked && KelainanPadaPupilMata.isChecked && TekananBolaMataMeningkat.isChecked && SumberCahayaBerwarnaPelangi.isChecked) {
                namaPenyakit += "$P03, "
                Log.d("Check", namaPenyakit)

            }
            if (MataBerair.isChecked && MataBengkak.isChecked && MataTerasaGatal.isChecked
                && MataTerasaPanas.isChecked && MataTerasaNyeri.isChecked) {
                namaPenyakit += "$P04, "
                Log.d("Check", namaPenyakit)

            }
            if (SakitKepala.isChecked && MataLelah.isChecked && SeringMengedipkanMata.isChecked
                && PenglihatanObjekJauhKurangJelas.isChecked) {
                namaPenyakit += "$P05, "
                Log.d("Check", namaPenyakit)

            }
            if (MataBerair.isChecked && MataBerwarnaMerah.isChecked && LemakMenutupiKornea.isChecked) {
                namaPenyakit += "$P06, "
                Log.d("Check", namaPenyakit)

            }
            if (SakitKepala.isChecked && PenglihatanDekatTerasaKabur.isChecked && MenyipitkanMata.isChecked) {
                namaPenyakit += "$P07, "
                Log.d("Check", namaPenyakit)
            }

            if (PenglihatanTerasaKabur.isChecked && MataTegang.isChecked) {
                namaPenyakit += "$P08, "
                Log.d("Check", namaPenyakit)
            }


            if (namaPenyakit.isNotEmpty()) {
                namaPenyakit = namaPenyakit.substring(0, namaPenyakit.length - 2)
            }else {
                // Jika tidak ada nama penyakit yang terdeteksi, set namaPenyakit sebagai "Penyakit tidak terdeteksi".
                namaPenyakit = "Penyakit tidak terdeteksi"
            }

            // Navigasi ke halaman ResultFragment dan mengirimkan data namaPenyakit melalui bundle.
            val bundle = Bundle()
            bundle.putString("diagnosa", namaPenyakit)
            findNavController().navigate(R.id.action_diagnoseFragment_to_resultFragment,bundle)

            // Menyimpan hasil diagnosa ke Firebase Realtime Database bersama dengan waktu dan tanggal.
            val dateTime = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())
            val diagnosaData = HashMap<String, Any>()
            diagnosaData["result"] = namaPenyakit
            diagnosaData["datetime"] = dateTime

            diagnosaRef.push().setValue(diagnosaData)
                .addOnSuccessListener {
                    Toast.makeText(requireContext(), "Diagnosa berhasil disimpan", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Toast.makeText(requireContext(), "Gagal menyimpan diagnosa", Toast.LENGTH_SHORT).show()
                }
        }
        return view
    }

    // Membersihkan referensi view binding (_binding) ketika fragment dihancurkan.
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // Menambahkan aksi ketika tombol back ditekan.
    // Ketika tombol back ditekan, fragment akan melakukan navigasi ke atas (navigateUp) menggunakan NavController.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().navigateUp()
        }
    }
}
