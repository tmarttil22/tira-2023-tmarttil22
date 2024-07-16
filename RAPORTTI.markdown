# Raportit tehtävistä

Kirjaa tähän tiedostoon **jokaiseen** tehtävään liittyvät omat raporttisi ja analyysisi. Muista että raportti on myös kurssilla **arvosteltava tehtävä**.

Voit sisällyttää raporttiin tekstimuotoisia taulukoita (tasaukset välilyönnein):

```
n     Fill     Search   Total
500   7        700      707
1000  9        288      297
```

Ja näihin liittyviä kuvatiedostoja:

![Esimerkkikuva](report-sample-image.png)

Nämä näkyvät sitten VS Coden Preview -näkymässä (tai oman repositorysi webbisivulla) oikein muotoiltuna. Käytä tässä dokumentissa olevia muotoiluja esimerkkinä kun kirjoitat raporttiasi. 

Huomaa että jos laitat kuvatiedostot vaikka omaan alihakemistoonsa, Markdown -muotoilussa on oltava suhteellinen polku tiedostoon, esimerkiksi `images/report-sample-image.png`. **Älä** käytä absoluuttisia polkuja `C:\Users\tippaleipa\kurssit\TIRA\kuva.png`, koska nämä eivät tietenkään toimi opettajan koneella. Ei kannata laittaa linkkiä etärepoosikaan, vaan nimenomaan paikalliseen tiedostoon.

Voit myös sisällyttää *lyhyitä* koodinpätkiä vaikkapa Java -formaatilla:

```Java
	@Override
	public int hashCode() {
		// Oma nerokas hajautufunktioni!
	}
```
Tarvittaessa käytä myös paremmin muotoiltuja taulukoita:

| n	| Fill	| Search	| Total |
|-----|--------|--------|-------|
| 500	 | 7	| 700	| 707 |
| 1000 |	9	| 288	| 297 | 

Alaluvut jokaisen tehtävän raportille löydät alta.


## 01-TASK
Tehtävän tekemisessä opin päällimmäisenä, että while- lauseen (ja oletettavasti kaikki samankaltainen) ehdon järjestyksellä on väliä, kun ne erotellaan '&&' merkillä.
"while (j >= 0 && current.compareTo(array[j]) < 0)" otti sorttaamiseen mukaan arrayn ensimmäisen elementin, samalla kun "while (current.compareTo(array[j] && j >= 0) < 0)" koodilla arrayn ensimmäinen elementti pysyi aina paikallaan.
Sanoisin että reverse() metodien luominen oli jokseenkin helppoa, mutta itse insertionSort() metodien äärellä jouduin ajattelemaan, käyttämään enemmän aikaa ymmärtämiseen.

Aikakompleksisuusluokat molemmille insertionSort() sekä reverse() metodeille O(n) eli lineaariset.

Jos taulukko on jo valmiiksi järjestyksessä nousevaan järjestykseen, ja se aiotaan lajitella laskevaan järjestykseen,
sen järjestys kannattaa vaihtaa sillä for-loop käydään läpi "array.length / 2" verran, samalla kun lajittelumetodissa se käydään läpi "array.length" verran.



## 02-TASK
Tehtävässä opin koodin korjaamista ja vian löytämistä seuraamalla missä virheet ovat tapahtuneet katsomalla virheilmoituksia, käymällä kaikki funktiokutsut mitkä johtavat tähän virheeseen läpi ja tarkasti ajatellen sekä pohtien huomaten, mikä ongelman juuri on.
Vaikeaksi koin aluksi Comparable-rajapinnan ymmärtämisen mutta sain sen ymmärretyksi kun käsittelin metodeita mihin sen käyttö kuului.

Jos aineisto on jo valmiiksi lajiteltu, kannattaa käyttää reverse-algoritmia, sillä sillä tavalla täytyy käydä vain puolet aineiston alkioista läpi, säästäen aikaa.

Toteutettuja algoritmejä kutsutaan lineaarisiksi, koska niiden suoritusaika kasvaa lineaarisesti (suoraan) ylöspäin n:n kasvaessa. Big-O notaatiossa tätä merkitään O(n).

Kuvasta voidaan päätellä, että täyttöajan aikakompleksisuus on O(n), mutta hakuajan aikakompleksisuus pysyy aikalailla samana, lukuun ottamatta alkua jossa suhdeluku alkaa tosi korkealta (2.66 kun n=500, 0.73 kun n=1000), sekä näennäisesti satunnaisia piikkejä kun suhdeluku onkin huomattavasti eri. 
![Käyrät](image.png)
![Käyrät 2](image-11.png)



## 03-TASK
Koin tämän tehtävän helpoksi, binarysearch oli helppo ymmärtää ja sen kaikki versiot helppo toteuttaa. Päätin tehdä binäärihaut iteratiivisesti.

![Fill in relation to growth of n](image-12.png)
![Sort in relation to growth of n](image-13.png)
![Search in relation to growth of n](image-14.png)

Lineaarisen haun aikakompleksisuus on O(n), samalla kun puolitushaun aikakompleksisuus on suurilla aineistolla todella huomattavasti parempi, O(logn). Kuvasta nähdään miten taulukon hakuaika n suhteen pysyy alhaalla (heti ensimmäisen piikin jälkeen) ja pysyy hyvin O(logn) suunnilla.

## 04-TASK
Tehtävän tekemisessä opin miten stackit toimivat, ja sain niistä syvempää ymmärrystä. Lisäksi tiedän nyt myös JSON-tiedostojen lukemisesta enemmän mitä aiemmin. Koin tehtävän olevan haastavuustasolla tosi tasainen kaikissa tehtävän osissa, en kokenut minkään olevan liian hankalaa tai niin helppoa että olisin päässyt vähällä. Viimeisimmän bugin löytäminen pop() metodista tuotti hankaluuksia.

Aikakompleksisuusvaatimukset ovat saavuitettu, sillä kaikki O(1) metodit kestävät saman ajan suorittaa, riippumatta esimerkiksi syötöstä tai pinon senhetkisestä tilasta. kaikki O(n) aikakompleksiset metodit on myös toteutettu aikakompleksisuusrajoissa.

Jos tarkistimen saanut teksti sisältää vain yhden tai parittoman määrän lainausmerkkejä, se lukee viimeisestä lainausmerkistä koko loppu tiedoston niin kuin se kuuluisi lainausmerkkien sisälle, eikä laskisi mukaan siellä esiintyviä sulkeita. Tarkistin ei myöskään ilmoittaisi tästä käyttäjälle, joten oikeellisuus ei toteudu jos lainausmerkkejä on käytetty väärin.



## 05-TASK
Hankalimmaksi tehtävässä koin allocateSpace() methodin toteuttamisen, koska koin suuria hankaluuksia saada ymmärrykseen miten ottaisin jonon muodon (head sekä tail indeksien muuttuvat arvot) konseptin mukaan arrayn kopioon. Lopulta onnistuin, kun vähensin monimutkaisuutta ratkaisussani jota oli kertynyt liiallisen yrittelyn takia. Jonon toiminnallisuuden ymmärtäminen oli aluksi haastavaa mutta tietyn ajan kuluttua oli sisästettynä. toString oli myös hiukan haastava toteuttaa, mutta muuten en kokenut tehtävässä hankaluuksia.

Linkitettyyn listaan ei ikinä tarvitse allokoida lisää tilaa, koska jokainen uusi lisätty node sisältää viittauksen seuraavaan (mahdollisesti myös edelliseen) nodeen. Tämän takia linkitety lista ei vaadi valmiiksi määrättyä määrää tilaa muistista, vaan se kasvaa tai pienenee nodejen määrien mukaan. Samaan aikaan jonossa on vakaa määrä muistia, kunnes sitä täytyy lisätä. Riippuu käyttötarkoituksesta, kumpi sopii paremmin: jos tiedetään että elementtien lisäämistä ja poistamista tapahtuu usein, voi linkitetty lista olla parempi. Jos taas satunnainen pääsy tietoihin on tärkeämpää/useammin tapahtuvaa, luultavasti jono toimii tehokkaammin.

Kaikki methodit jotka vaativat O(1) aikakompleksisuutta ovat O(1) aikakompleksisiä, koska kaikissa niissä menee täysin sama aika suorittaa riippumatta mitä metodille syötetään. Poikkeuksena enqueue() silloin kun allocateSpace() methodia kutsutaan, koska sen aikakompleksisuus on O(n), sekä luonnollisesti toString() (jossa for-loop jokaisen jonon alkion läpi). Yhdessäkään O(1) aikakompleksisuutta vaativassa methodissa ei ole mitään silmukkaa.



## 06-TASK
Opin tehtävässä miten mergesort toimii koodaamisen tasolla, sekä miten heapsort ja quicksort toimivat pinnallisella tasolla. Mergesortin toiminta oli hankala sisäistää ja toteuttaa koodiksi.

CodersSlowComparatorTests tuloksien ja niistä tehtyjen käyrien perusteella voi päätellä, että suoritusaika kasvaa lineaarista nopeammin korkeammaksi, ja silmämääräisesti algoritmin aikakompleksisuusluokka voisi olla O(n*logn)

Lisäksi aika, jota käytetään yhden elementin käsittelyyn, kasvaa moninkertaiseksi verrattuna pienen, 100 koodaajan tiedoston aikaan. Pienimmillään aikaa kului 0,033 ms per elementti 1000 koodarin tiedostossa, suurimmillaan kului 2,82 ms 100 000 koodarin tiedostossa. Tässä huomataan yksi syy, miksi hitaan algoritmin aikakompleksisuusluokka ei ole O(n)
![Slow Comparator test graphs](image-1.png)

CodersFastComparatorTests tuloksista tuotettu, kuvassa näkyvä, "Fast test ms" käyrä taas kasvaa silminnähden lineaarisesti suuremmaksi, ja verrattuna 2 miljoonan koodareiden tiedostoa 1 miljoonan koodarin tiedostoon, käsittelyyn kuluva aika on n. 48%. Tästä syystä, sekä käyrän lineaarisesta muodosta, aikakompleksisuusluokka on lähellä O(n), jos dataa olisi paljon enemmän, voitaisiin laskea tarkemmalla tarkkuudella algoritmin aikakompleksisuusluokka.

Ms/element arvo alkaa huomattavasti muita arvoja korkeamalta pienellä aineistomäärällä, ja nopeasti tipahtaa alas alle 0,01ms käsittelyaikaan per elementti. Tämä käsittelyaika elementille kasvaa todella vähän vaikka tiedoston koko kasvaisi todella paljon, ero 5000 ja 2 000 000 koodarin tiedoston keskiverto ms/element käsittelyajan on 0,004 - 0,002 = 0,002ms
![Fast Comparator test graphs](image-2.png)

![Raw numbers in Excel](image-3.png)

Nopea algoritmi käsitteli testit ajassa 488, ja hidas ajassa 365 212. Nopea algoritmi käytti siis 0.1% hitaan ajasta, saman asian hoitamiseen. Hidas algoritmi (insertionsort) joutuu vaihtelemaan paljon elementtien paikkoja koko listasta kun siihen lisätään uusia elementtejä, joka johtaa suuremmilla elementtimäärillä suurempiin ms/element käsittelyaikoihin. Mergesort taas tekee päälistasta pienempiä listoja, joihin lisääminen tapahtuu paljon tehokkaammin

Insertionsort on vielä hyväksyttävän tehokas joihinkin käyttötarkoituksiin pienillä tiedoston elementtimäärillä, mutta mergesort on näiden testien nojalla (yli 100 elementin tiedostoissa) aina tehokkaampi ja nopeampi.



## 07-TASK

Tehtävä opetti sekä sai ajattelemaan syvästi miten BST toimii, minkälainen siitä muodostuu ja mitä hyötyjä siitä on muihin tietorakenteisiin verrattuna. Hankalaksi koin itse TreeNode luokan luomisen ja sen oikeellisen käyttämisen itse BSTContainerissa, sekä BST:n tekemisen aloittaminen tuntui vaikealta ennenkuin pääsin vauhtiin.

Jos puut täyttäisi tasapainoisesti, puun syvyydet olisivat jokaisella aineistomäärällä:
10->4    100->7    1000->10    5000->13    10 000->14    50 000->16    100 000->17    1 000 000->20    2 000 000->21

Minun implementoivani algoritmin puun syvyydet (sortataan jokaista tulosta varten täydellä nimellä) olivat taas:
10->5    100->11    1000->20    5000->27    10 000->29    50 000->36    100 000->41    1 000 000->48    2 000 000->ei mitattu
(Tulokset vaihtelevat kun vaihdellaan jatkuvasti esim. full name asc. ja desc. välillä, puun pituus voi muuttua paljon, mitä suurempi aineisto, sitä suurempi mahdollisuus huonommalle puulle. Dokumentoin tähän lyhyimmät tulokset)
(Lisäksi Coder nimillä puista tulee paljon pidempiä kuin oikeilla nimillä)

Suurin osa metodeista on tehty toteutustavalla A, mutta indexOf() on tehty iteroiden tavalla B. Rekursiivinen tapa tuntui muuten helpoimmalta tehdä, mutta indexOf() metodin tapauksessa iteroiva tapa tuntui helpommalta ymmärtää ja sisäistää. Jos saisin valita uudelleen, harkitsisin Visitorin tekemistä että oppisin, miten se toimisi.

![BST vs Simplecontainer add times per element](image-4.png)

![Simplecontainer add time/item chart](image-8.png)

Elementtien lisääminen kasvaa bst:llä todella minimaalisen määrän per elementti (puhutaan millisekunnin kymmenestuhannesosista) kun aineiston koko kasvaa, samalla kun simplecontainerin aika per elementti kasvaa yli millisekuntiin
100 000 kokoisella aineistolla.

![BST search time chart](image-7.png)

Hakuaika BST:n kanssa kasvaa vain kymmenissä millisekunneissa, samalla kun simplecontainerin hakuaika kasvaa jo 50 000 yli 10 sekuntiin

![BST get(index) time chart](image-6.png)

BST:n getIndex() metodiin menevä aika kasvaa suuremmalla tahdilla, mitä suurempi aineiston määrä on. Jos tässä implementaatiossa käytettäisiin tapaa D (lapsisolmujen määrän tiedon hyödyntämistä), olisi algoritmi tässä satoja kertoja tehokkaampi ja koko aineistoon ei menisi monia sekunteja.

![Simplecontainer raw data](image-9.png)

![BST raw data](image-10.png)

## 08-TASK

## 09-TASK