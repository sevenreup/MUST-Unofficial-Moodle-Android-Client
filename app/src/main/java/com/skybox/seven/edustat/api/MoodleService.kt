package com.skybox.seven.edustat.api

import com.skybox.seven.edustat.model.*
import com.skybox.seven.edustat.model.prefs.PreferenceResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Servies connecting to any Must moodle
 * Boolean's are expressed interms of 1 and 0
 */
interface MoodleService {
    /**
     * Authentication
     * using the default service used by the official app
     * @param
     */
    @GET("login/token.php?service=moodle_mobile_app")
    fun login(@Query("username") username: String, @Query("password") password: String): Single<AuthResponse>

    /**
     * Get site information, {mostly just for getting the userId}
     */
    @GET("webservice/rest/server.php?wsfunction=core_webservice_get_site_info")
    fun getSite(): Single<Site>

    /**
     * Get all the user courses
     */
    @GET("webservice/rest/server.php?wsfunction=core_enrol_get_users_courses")
    fun getCourses(@Query("userid") id: Int): Single<List<Course>>

    /**
     * Get course information
     * param
     */
    @GET("webservice/rest/server.php?wsfunction=core_course_get_contents")
    fun getCourseContent(@Query("courseid") courseID: Int): Single<List<Section>>
    /**
     * Get all user chats without the complicated params
     * @param mergeSelf (whether to include self-conversations (true) or ONLY private conversations (false) when private conversations are requested.)
     * @param type (the type of the conversation, if you wish to filter to a certain type (see api constants).)
     * can get groups/self by changing param {type} @link Constants
     */
    @GET("webservice/rest/server.php?wsfunction=core_message_get_conversations")
    fun getAllChats(@Query("userid") id: Int, @Query("limitfrom") limitFrom: Int,
                    @Query("limitnum") limitNum: Int, @Query("type") type: Int ,@Query("mergeself") mergeSelf: Int): Single<ConversationResponse>

    /**
     * Get all user chats with the complicated params
     * @param favorites (whether to include NO favourites (false) or ONLY favourites (true), or null to ignore this setting.)
     * exactly the same as above but now can get favorites of different type
     */
    @GET("webservice/rest/server.php?wsfunction=core_message_get_conversations")
    fun getAllFavorites(@Query("userid") id: Int, @Query("limitfrom") limitFrom: Int,
                    @Query("limitnum") limitNum: Int, @Query("type") type: Int,
                    @Query("favourites") favorites: Int, @Query("mergeself") mergeSelf: Int): Single<ConversationResponse>

    /**
     * Get all messages in Chat
     * This is different from the Doc (Don't know why).
     * This implementation is taken from the official app
     */
    @GET("webservice/rest/server.php?wsfunction=core_message_get_conversation_messages")
    fun getAllMessagesInChat(@Query("currentuserid") userId: Int, @Query("convid") convId: Int, @Query("limitfrom") limitFrom: Int,
                   @Query("limitnum") limitNum: Int, @Query("newest") newest: Int): Single<Chat>

    /**
     * Get all notifications
     * Has pagination and whatnot
     */
    @GET("webservice/rest/server.php?wsfunction=message_popup_get_popup_notifications")
    fun getAllNotifications(@Query("useridto") userId: Int, @Query("newestfirst") newFirst: Int,
                            @Query("offset") offset: Int, @Query("limit") limit: Int): Single<NotificationsResponse>

    /**
     * Get all unread notifications
     */
    @GET("webservice/rest/server.php?wsfunction=message_popup_get_unread_popup_notification_count")
    fun getNotificationUnreadCount(@Query("useridto") userId: Int): Single<Int>

    /**
     * Mark all notifications as read
     * Todo: (returns as 'true' check if its not string)
     */
    @GET("webservice/rest/server.php?wsfunction=core_message_mark_all_notifications_as_read")
    fun getMarkAllNotificationsAsRead(@Query("useridto") userId: Int): Single<Boolean>

    /**
     * Mark notification as read
     * timestamp (UNIX format, seconds) current timestamp in seconds
     */
    @GET("webservice/rest/server.php?wsfunction=core_message_mark_notification_read")
    fun getMarkNotificationAsRead(@Query("notificationid") notID: Int, @Query("timeread") timeStamp: Int): Single<Boolean>

    /**
     * Get all notification preferences
     */
    @GET("webservice/rest/server.php?wsfunction=core_message_get_user_notification_preferences")
    fun getNotificationPreferences(@Query("userid") userID: Int): Single<PreferenceResponse>

    /**
     * Get all notification preferences
     */
    @GET("webservice/rest/server.php?wsfunction=core_user_add_user_device")
    fun addUserDevicePushToNotification(@Query("appid") appID: String, @Query("name") deviceName: String,
                                        @Query("model") deviceModel: String, @Query("platform") platform: String,
                                        @Query("version") version: String, @Query("pushid") pushID: String,
                                        @Query("uuid") uuid: String): Single<PreferenceResponse>

    /**
     * Get users profile using course
     */
    @GET("webservice/rest/server.php?wsfunction=core_user_get_course_user_profiles")
    fun getUserProfileByCourse(@Query("userlist") list: Array<UserProfileRequests>): Single<List<UserResponse>>

    /**
     * Get users profile using field type
     */
    @GET("webservice/rest/server.php?wsfunction=core_user_get_users_by_field")
    fun getUserProfileByField(@Query("field") field: String, @Query("values[]") values: List<Int>): Single<List<UserResponse>>
}