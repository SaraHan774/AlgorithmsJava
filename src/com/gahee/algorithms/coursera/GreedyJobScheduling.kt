package com.gahee.algorithms.coursera

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


fun main() {
    Greedy1().readInputs()
}

data class Job(
    val weight: Int,
    val length: Int
)

class Greedy1 {

    // read job
    lateinit var arr: Array<Job?>

    // http request
    fun readInputs() {
        val connection = (URL(url).openConnection() as HttpURLConnection)
            .apply {
                this.requestMethod = "GET"
            }
        BufferedReader(InputStreamReader(connection.inputStream)).use { br ->
            val n = br.readLine().toInt()
            arr = Array(n) { null }

            var line: String?
            var i = 0;
            while (br.readLine().also { line = it } != null) {
                val j = line?.split(" ")?.let {
                    return@let Job(weight = it.first().toInt(), length = it.last().toInt())
                }
                arr[i++] = j
            }
        }
    }

    // TODO : greedy algorithm
    fun doGreedy() {

    }

    companion object {
        private const val url = "https://d3c33hcgiwev3.cloudfront.net/_642c2ce8f3abe387bdff636d708cdb26_jobs.txt?Expires=1658275200&Signature=VTTwE0RAIEx0x6oKemBVuxzYuAypqKygm3yx71kC-QpPQEq3s4-iFD0I6L3Q5HJyjdRUrXEyg6EOdx~l0gl3gSnRtXQyqHEBrynGftGS7-lIqz3uFJhdcbaEu79goWEwDqR7DUkIi682hiO~3kdCnDMveilAMm2dn-S0fYXSHhk_&Key-Pair-Id=APKAJLTNE6QMUY6HBC5A"
    }
}
