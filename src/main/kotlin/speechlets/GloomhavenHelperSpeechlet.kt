package speechlets

import com.amazon.speech.speechlet.*
import com.amazon.speech.ui.PlainTextOutputSpeech
import com.amazon.speech.ui.SimpleCard

class GloomhavenHelperSpeechlet : Speechlet {
    override fun onSessionStarted(request: SessionStartedRequest?, session: Session?) {

    }

    override fun onSessionEnded(request: SessionEndedRequest?, session: Session?) {

    }

    override fun onIntent(request: IntentRequest?, session: Session?): SpeechletResponse {
        val intent = request!!.intent
        val intentName = intent?.name

        return when (intentName) {
            "CheckRule" -> checkKeywordResponse()
            "CheckLevel" -> checkLevelRewardResponse()
            else -> throw SpeechletException("Invalid Intent")
        }
    }

    override fun onLaunch(request: LaunchRequest?, session: Session?): SpeechletResponse {
        return checkKeywordResponse()
    }

    private fun checkKeywordResponse(): SpeechletResponse {

        var keywordOutput = ""

        val speechText = "Welcome to the Gloomhaven helper. $keywordOutput"
        val card = SimpleCard()
        card.title = "Gloomhaven Rule Helper"
        card.content = speechText
        val speech = PlainTextOutputSpeech()
        speech.text = speechText

        return SpeechletResponse.newTellResponse(speech, card)
    }

    private fun checkLevelRewardResponse(): SpeechletResponse {

        return checkKeywordResponse() //for now just call the other method
    }
}