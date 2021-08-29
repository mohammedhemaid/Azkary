package com.app.durdling.azkar

data class DataSet(val text: String, val count: Int) {

    companion object {
        val listOfAzkar = mutableListOf(
            DataSet("استغفر الله", 0),
            DataSet("لا إله إلا الله", 0),
            DataSet("اللهم صل على سيدنا محمد وعلى آله وصحبه وسلم", 0),
            DataSet("سُـبْحانَ الله والحَمْـدُ لله ولا إله إلا الله واللهُ أكْـبَر", 0),
            DataSet("سُبْحانَ اللَّهِ وبِحَمْدِهِ، سُبْحانَ اللَّهِ العَظِيمِ", 0),
            DataSet("لَا حَوْلَ وَلَا قُوَّةَ إِلَّا بِالله", 0),
            DataSet("حَسْبُنَا اللَّهُ وَنِعْمَ الْوَكِيلُ", 0),
        )
    }
}