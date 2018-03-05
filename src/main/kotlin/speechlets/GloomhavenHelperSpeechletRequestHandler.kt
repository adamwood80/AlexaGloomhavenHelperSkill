package speechlets

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler

class GloomhavenHelperSpeechletRequestHandler : SpeechletRequestStreamHandler(GloomhavenHelperSpeechlet(), supportedApplicationIds){

    companion object {
        private val supportedApplicationIds = HashSet<String>()

        init {
            supportedApplicationIds.add("amzn1.ask.skill.56dcf550-93be-468a-a663-6d7998cd4711")
        }
    }
}