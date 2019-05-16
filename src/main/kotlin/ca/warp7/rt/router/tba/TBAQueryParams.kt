package ca.warp7.rt.router.tba

data class TBAQueryParams(
    val team_key: String? = null,
    val district_key: String? = null,
    val match_key: String? = null,
    val event_key: String? = null,
    val year: String? = null,
    val media_tag: String? = null,
    val page_num: String? = null
) {
    fun format(template: String): String {
        var s = template
        team_key?.also { s = s.replace("{team_key}", it)}
        district_key?.also { s = s.replace("{district_key}", it)}
        match_key?.also { s = s.replace("{match_key}", it)}
        event_key?.also { s = s.replace("{event_key}", it)}
        team_key?.also { s = s.replace("{team_key}", it)}
        year?.also { s = s.replace("{year}", it)}
        media_tag?.also { s = s.replace("{media_tag}", it)}
        page_num?.also { s = s.replace("{page_num}", it)}
        return s
    }
}