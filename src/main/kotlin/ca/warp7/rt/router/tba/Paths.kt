@file:Suppress("unused", "SpellCheckingInspection", "KDocUnresolvedReference")

package ca.warp7.rt.router.tba

/**
 * Returns API status, and TBA status information.
 */
suspend fun TBA.getStatus(): APIStatus {
    val response = get("/status")
    TODO()
}

/**
 * Gets a list of `Team` objects, paginated in groups of 500.
 */
suspend fun TBA.getTeams(
    page_num: Int
): List<Team> {
    val response = get("/teams/$page_num")
    TODO()
}

/**
 * Gets a list of short form `Team_Simple` objects, paginated in groups of 500.
 */
suspend fun TBA.getTeamsSimple(
    page_num: Int
): List<TeamSimple> {
    val response = get("/teams/$page_num/simple")
    TODO()
}

/**
 * Gets a list of Team keys, paginated in groups of 500. (Note, each page will not have 500 teams, but will include the teams within that range of 500.)
 */
suspend fun TBA.getTeamsKeys(
    page_num: Int
): List<String> {
    val response = get("/teams/$page_num/keys")
    TODO()
}

/**
 * Gets a list of `Team` objects that competed in the given year, paginated in groups of 500.
 */
suspend fun TBA.getTeamsByYear(
    year: Int,
    page_num: Int
): List<Team> {
    val response = get("/teams/$year/$page_num")
    TODO()
}

/**
 * Gets a list of short form `Team_Simple` objects that competed in the given year, paginated in groups of 500.
 */
suspend fun TBA.getTeamsByYearSimple(
    year: Int,
    page_num: Int
): List<TeamSimple> {
    val response = get("/teams/$year/$page_num/simple")
    TODO()
}

/**
 * Gets a list Team Keys that competed in the given year, paginated in groups of 500.
 */
suspend fun TBA.getTeamsByYearKeys(
    year: Int,
    page_num: Int
): List<String> {
    val response = get("/teams/$year/$page_num/keys")
    TODO()
}

/**
 * Gets a `Team` object for the team referenced by the given key.
 */
suspend fun TBA.getTeam(
    team_key: String
): Team {
    val response = get("/team/$team_key")
    TODO()
}

/**
 * Gets a `Team_Simple` object for the team referenced by the given key.
 */
suspend fun TBA.getTeamSimple(
    team_key: String
): TeamSimple {
    val response = get("/team/$team_key/simple")
    TODO()
}

/**
 * Gets a list of years in which the team participated in at least one competition.
 */
suspend fun TBA.getTeamYearsParticipated(
    team_key: String
): List<Int> {
    val response = get("/team/$team_key/years_participated")
    TODO()
}

/**
 * Gets an array of districts representing each year the team was in a district. Will return an empty array if the team was never in a district.
 */
suspend fun TBA.getTeamDistricts(
    team_key: String
): List<DistrictList> {
    val response = get("/team/$team_key/districts")
    TODO()
}

/**
 * Gets a list of year and robot name pairs for each year that a robot name was provided. Will return an empty array if the team has never named a robot.
 */
suspend fun TBA.getTeamRobots(
    team_key: String
): List<TeamRobot> {
    val response = get("/team/$team_key/robots")
    TODO()
}

/**
 * Gets a list of all events this team has competed at.
 */
suspend fun TBA.getTeamEvents(
    team_key: String
): List<Event> {
    val response = get("/team/$team_key/events")
    TODO()
}

/**
 * Gets a short-form list of all events this team has competed at.
 */
suspend fun TBA.getTeamEventsSimple(
    team_key: String
): List<EventSimple> {
    val response = get("/team/$team_key/events/simple")
    TODO()
}

/**
 * Gets a list of the event keys for all events this team has competed at.
 */
suspend fun TBA.getTeamEventsKeys(
    team_key: String
): List<String> {
    val response = get("/team/$team_key/events/keys")
    TODO()
}

/**
 * Gets a list of events this team has competed at in the given year.
 */
suspend fun TBA.getTeamEventsByYear(
    team_key: String,
    year: Int
): List<Event> {
    val response = get("/team/$team_key/events/$year")
    TODO()
}

/**
 * Gets a short-form list of events this team has competed at in the given year.
 */
suspend fun TBA.getTeamEventsByYearSimple(
    team_key: String,
    year: Int
): List<EventSimple> {
    val response = get("/team/$team_key/events/$year/simple")
    TODO()
}

/**
 * Gets a list of the event keys for events this team has competed at in the given year.
 */
suspend fun TBA.getTeamEventsByYearKeys(
    team_key: String,
    year: Int
): List<String> {
    val response = get("/team/$team_key/events/$year/keys")
    TODO()
}

/**
 * Gets a key-value list of the event statuses for events this team has competed at in the given year.
 */
suspend fun TBA.getTeamEventsStatusesByYear(
    team_key: String,
    year: Int
): Any {
    val response = get("/team/$team_key/events/$year/statuses")
    TODO()
}

/**
 * Gets a list of matches for the given team and event.
 */
suspend fun TBA.getTeamEventMatches(
    team_key: String,
    event_key: String
): List<Match> {
    val response = get("/team/$team_key/event/$event_key/matches")
    TODO()
}

/**
 * Gets a short-form list of matches for the given team and event.
 */
suspend fun TBA.getTeamEventMatchesSimple(
    team_key: String,
    event_key: String
): List<Match> {
    val response = get("/team/$team_key/event/$event_key/matches/simple")
    TODO()
}

/**
 * Gets a list of match keys for matches for the given team and event.
 */
suspend fun TBA.getTeamEventMatchesKeys(
    team_key: String,
    event_key: String
): List<String> {
    val response = get("/team/$team_key/event/$event_key/matches/keys")
    TODO()
}

/**
 * Gets a list of awards the given team won at the given event.
 */
suspend fun TBA.getTeamEventAwards(
    team_key: String,
    event_key: String
): List<Award> {
    val response = get("/team/$team_key/event/$event_key/awards")
    TODO()
}

/**
 * Gets the competition rank and status of the team at the given event.
 */
suspend fun TBA.getTeamEventStatus(
    team_key: String,
    event_key: String
): TeamEventStatus {
    val response = get("/team/$team_key/event/$event_key/status")
    TODO()
}

/**
 * Gets a list of awards the given team has won.
 */
suspend fun TBA.getTeamAwards(
    team_key: String
): List<Award> {
    val response = get("/team/$team_key/awards")
    TODO()
}

/**
 * Gets a list of awards the given team has won in a given year.
 */
suspend fun TBA.getTeamAwardsByYear(
    team_key: String,
    year: Int
): List<Award> {
    val response = get("/team/$team_key/awards/$year")
    TODO()
}

/**
 * Gets a list of matches for the given team and year.
 */
suspend fun TBA.getTeamMatchesByYear(
    team_key: String,
    year: Int
): List<Match> {
    val response = get("/team/$team_key/matches/$year")
    TODO()
}

/**
 * Gets a short-form list of matches for the given team and year.
 */
suspend fun TBA.getTeamMatchesByYearSimple(
    team_key: String,
    year: Int
): List<MatchSimple> {
    val response = get("/team/$team_key/matches/$year/simple")
    TODO()
}

/**
 * Gets a list of match keys for matches for the given team and year.
 */
suspend fun TBA.getTeamMatchesByYearKeys(
    team_key: String,
    year: Int
): List<String> {
    val response = get("/team/$team_key/matches/$year/keys")
    TODO()
}

/**
 * Gets a list of Media (videos / pictures) for the given team and year.
 */
suspend fun TBA.getTeamMediaByYear(
    team_key: String,
    year: Int
): List<Media> {
    val response = get("/team/$team_key/media/$year")
    TODO()
}

/**
 * Gets a list of Media (videos / pictures) for the given team and tag.
 */
suspend fun TBA.getTeamMediaByTag(
    team_key: String,
    media_tag: String
): List<Media> {
    val response = get("/team/$team_key/media/tag/$media_tag")
    TODO()
}

/**
 * Gets a list of Media (videos / pictures) for the given team, tag and year.
 */
suspend fun TBA.getTeamMediaByTagYear(
    team_key: String,
    media_tag: String,
    year: Int
): List<Media> {
    val response = get("/team/$team_key/media/tag/$media_tag/$year")
    TODO()
}

/**
 * Gets a list of Media (social media) for the given team.
 */
suspend fun TBA.getTeamSocialMedia(
    team_key: String
): List<Media> {
    val response = get("/team/$team_key/social_media")
    TODO()
}

/**
 * Gets a list of events in the given year.
 */
suspend fun TBA.getEventsByYear(
    year: Int
): List<Event> {
    val response = get("/events/$year")
    TODO()
}

/**
 * Gets a short-form list of events in the given year.
 */
suspend fun TBA.getEventsByYearSimple(
    year: Int
): List<EventSimple> {
    val response = get("/events/$year/simple")
    TODO()
}

/**
 * Gets a list of event keys in the given year.
 */
suspend fun TBA.getEventsByYearKeys(
    year: Int
): List<String> {
    val response = get("/events/$year/keys")
    TODO()
}

/**
 * Gets an Event.
 */
suspend fun TBA.getEvent(
    event_key: String
): Event {
    val response = get("/event/$event_key")
    TODO()
}

/**
 * Gets a short-form Event.
 */
suspend fun TBA.getEventSimple(
    event_key: String
): EventSimple {
    val response = get("/event/$event_key/simple")
    TODO()
}

/**
 * Gets a list of Elimination Alliances for the given Event.
 */
suspend fun TBA.getEventAlliances(
    event_key: String
): List<EliminationAlliance> {
    val response = get("/event/$event_key/alliances")
    TODO()
}

/**
 * Gets a set of Event-specific insights for the given Event.
 */
suspend fun TBA.getEventInsights(
    event_key: String
): EventInsights {
    val response = get("/event/$event_key/insights")
    TODO()
}

/**
 * Gets a set of Event OPRs (including OPR, DPR, and CCWM) for the given Event.
 */
suspend fun TBA.getEventOPRs(
    event_key: String
): EventOPRs {
    val response = get("/event/$event_key/oprs")
    TODO()
}

/**
 * Gets information on TBA-generated predictions for the given Event. Contains year-specific information. *WARNING* This endpoint is currently under development and may change at any time.
 */
suspend fun TBA.getEventPredictions(
    event_key: String
): EventPredictions {
    val response = get("/event/$event_key/predictions")
    TODO()
}

/**
 * Gets a list of team rankings for the Event.
 */
suspend fun TBA.getEventRankings(
    event_key: String
): EventRanking {
    val response = get("/event/$event_key/rankings")
    TODO()
}

/**
 * Gets a list of team rankings for the Event.
 */
suspend fun TBA.getEventDistrictPoints(
    event_key: String
): EventDistrictPoints {
    val response = get("/event/$event_key/district_points")
    TODO()
}

/**
 * Gets a list of `Team` objects that competed in the given event.
 */
suspend fun TBA.getEventTeams(
    event_key: String
): List<Team> {
    val response = get("/event/$event_key/teams")
    TODO()
}

/**
 * Gets a short-form list of `Team` objects that competed in the given event.
 */
suspend fun TBA.getEventTeamsSimple(
    event_key: String
): List<TeamSimple> {
    val response = get("/event/$event_key/teams/simple")
    TODO()
}

/**
 * Gets a list of `Team` keys that competed in the given event.
 */
suspend fun TBA.getEventTeamsKeys(
    event_key: String
): List<String> {
    val response = get("/event/$event_key/teams/keys")
    TODO()
}

/**
 * Gets a key-value list of the event statuses for teams competing at the given event.
 */
suspend fun TBA.getEventTeamsStatuses(
    event_key: String
): Any {
    val response = get("/event/$event_key/teams/statuses")
    TODO()
}

/**
 * Gets a list of matches for the given event.
 */
suspend fun TBA.getEventMatches(
    event_key: String
): List<Match> {
    val response = get("/event/$event_key/matches")
    TODO()
}

/**
 * Gets a short-form list of matches for the given event.
 */
suspend fun TBA.getEventMatchesSimple(
    event_key: String
): List<MatchSimple> {
    val response = get("/event/$event_key/matches/simple")
    TODO()
}

/**
 * Gets a list of match keys for the given event.
 */
suspend fun TBA.getEventMatchesKeys(
    event_key: String
): List<String> {
    val response = get("/event/$event_key/matches/keys")
    TODO()
}

/**
 * Gets an array of Match Keys for the given event key that have timeseries data. Returns an empty array if no matches have timeseries data.
*WARNING:* This is *not* official data, and is subject to a significant possibility of error, or missing data. Do not rely on this data for any purpose. In fact, pretend we made it up.
*WARNING:* This endpoint and corresponding data models are under *active development* and may change at any time, including in breaking ways.
 */
suspend fun TBA.getEventMatchTimeseries(
    event_key: String
): List<String> {
    val response = get("/event/$event_key/matches/timeseries")
    TODO()
}

/**
 * Gets a list of awards from the given event.
 */
suspend fun TBA.getEventAwards(
    event_key: String
): List<Award> {
    val response = get("/event/$event_key/awards")
    TODO()
}

/**
 * Gets a `Match` object for the given match key.
 */
suspend fun TBA.getMatch(
    match_key: String
): Match {
    val response = get("/match/$match_key")
    TODO()
}

/**
 * Gets a short-form `Match` object for the given match key.
 */
suspend fun TBA.getMatchSimple(
    match_key: String
): MatchSimple {
    val response = get("/match/$match_key/simple")
    TODO()
}

/**
 * Gets an array of game-specific Match Timeseries objects for the given match key or an empty array if not available.
*WARNING:* This is *not* official data, and is subject to a significant possibility of error, or missing data. Do not rely on this data for any purpose. In fact, pretend we made it up.
*WARNING:* This endpoint and corresponding data models are under *active development* and may change at any time, including in breaking ways.
 */
suspend fun TBA.getMatchTimeseries(
    match_key: String
): List<Map<String, Any?>> {
    val response = get("/match/$match_key/timeseries")
    TODO()
}

/**
 * Gets a list of districts and their corresponding district key, for the given year.
 */
suspend fun TBA.getDistrictsByYear(
    year: Int
): List<DistrictList> {
    val response = get("/districts/$year")
    TODO()
}

/**
 * Gets a list of events in the given district.
 */
suspend fun TBA.getDistrictEvents(
    district_key: String
): List<Event> {
    val response = get("/district/$district_key/events")
    TODO()
}

/**
 * Gets a short-form list of events in the given district.
 */
suspend fun TBA.getDistrictEventsSimple(
    district_key: String
): List<EventSimple> {
    val response = get("/district/$district_key/events/simple")
    TODO()
}

/**
 * Gets a list of event keys for events in the given district.
 */
suspend fun TBA.getDistrictEventsKeys(
    district_key: String
): List<String> {
    val response = get("/district/$district_key/events/keys")
    TODO()
}

/**
 * Gets a list of `Team` objects that competed in events in the given district.
 */
suspend fun TBA.getDistrictTeams(
    district_key: String
): List<Team> {
    val response = get("/district/$district_key/teams")
    TODO()
}

/**
 * Gets a short-form list of `Team` objects that competed in events in the given district.
 */
suspend fun TBA.getDistrictTeamsSimple(
    district_key: String
): List<TeamSimple> {
    val response = get("/district/$district_key/teams/simple")
    TODO()
}

/**
 * Gets a list of `Team` objects that competed in events in the given district.
 */
suspend fun TBA.getDistrictTeamsKeys(
    district_key: String
): List<String> {
    val response = get("/district/$district_key/teams/keys")
    TODO()
}

/**
 * Gets a list of team district rankings for the given district.
 */
suspend fun TBA.getDistrictRankings(
    district_key: String
): List<DistrictRanking> {
    val response = get("/district/$district_key/rankings")
    TODO()
}
