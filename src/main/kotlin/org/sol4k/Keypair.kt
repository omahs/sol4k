package org.sol4k

import com.iwebpp.crypto.TweetNaclFast

class Keypair private constructor(
    private val keypair: TweetNaclFast.Signature.KeyPair,
) {

    val secret: ByteArray
        get() = keypair.secretKey

    val publicKey: PublicKey
        get() = PublicKey(keypair.publicKey)

    companion object {
        fun generate(): Keypair = Keypair(TweetNaclFast.Signature.keyPair())

        fun fromSecretKey(secret: ByteArray): Keypair {
            return Keypair(TweetNaclFast.Signature.keyPair_fromSeed(secret))
        }
    }
}