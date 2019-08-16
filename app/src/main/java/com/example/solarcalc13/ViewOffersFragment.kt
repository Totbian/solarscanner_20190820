package com.example.solarcalc13


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class ViewOffersFragment : Fragment(), View.OnClickListener {

    var amount:String? = null
    val msg = "$amount"

    var roof:Boolean? = null
    val msg2 = "be van pipálva"
    val msg3 = "nincs"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        amount = arguments!!.getString("amount")
        roof = arguments!!.getBoolean("roof")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_offers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button2).setOnClickListener(this)

        val message = "$amount"
        view.findViewById<TextView>(R.id.price_here_shown).text = message

        if(roof == true) {
            view.findViewById<Button>(R.id.button3).text = msg2
        }
        else {
            view.findViewById<Button>(R.id.button3).text = msg3
        }

    }

    private val sendIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, "Tisztelt Hölgyem/Uram, szeretnék ajánlatot kérni Önöktől, $msg forintot sporolnék havontaa")
        putExtra(Intent.EXTRA_EMAIL, "sooki.mihaly@mszk.bme.hu")
        putExtra(Intent.EXTRA_SUBJECT, "Ajánlat kérés SolarScanner applikáción keresztül napelemekre" + msg)
        putExtra(Intent.EXTRA_USER, "user")
        putExtra(Intent.EXTRA_CC, "cc")
        type = "text/plain"
    }

    private fun sendEmail(){
        startActivity(sendIntent)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.button2 -> sendEmail()
        }
    }
}
