package org.thoughtcrime.securesms.stories.viewer

import android.net.Uri
import org.thoughtcrime.securesms.recipients.RecipientId
import org.thoughtcrime.securesms.stories.StoryTextPostModel

data class StoryViewerState(
  val pages: List<RecipientId> = emptyList(),
  val previousPage: Int = -1,
  val page: Int = -1,
  val crossfadeSource: CrossfadeSource,
  val loadState: LoadState = LoadState()
) {
  sealed class CrossfadeSource {
    object None : CrossfadeSource()
    class ImageUri(val imageUri: Uri) : CrossfadeSource()
    class TextModel(val storyTextPostModel: StoryTextPostModel) : CrossfadeSource()
  }

  data class LoadState(
    val isContentReady: Boolean = false,
    val isCrossfaderReady: Boolean = false
  ) {
    fun isReady(): Boolean = isContentReady && isCrossfaderReady
  }
}
