@file:Suppress("unused", "SpellCheckingInspection", "KDocUnresolvedReference", "UNUSED_VARIABLE")

package ca.warp7.rt.router.tba

/**
 * Returns API status, and TBA status information.
 */
suspend fun TBA.getStatus(): APIStatus {
    val response = get("/status")
    return APIStatus(
        raw = response,
        current_season = response.int("current_season"),
        max_season = response.int("max_season"),
        is_datafeed_down = response.boolean("is_datafeed_down"),
        down_events = response.stringList("down_events"),
        ios = response.obj("ios")?.let { ios ->
            APIStatusAppVersion(
                raw = ios,
                min_app_version = ios.int("min_app_version"),
                latest_app_version = ios.int("latest_app_version")
            )
        },
        android = response.obj("android")?.let { android ->
            APIStatusAppVersion(
                raw = android,
                min_app_version = android.int("min_app_version"),
                latest_app_version = android.int("latest_app_version")
            )
        }
    )
}

/**
 * Gets a list of `Team` objects, paginated in groups of 500.
 */
suspend fun TBA.getTeams(
    page_num: Int
): List<Team> {
    val response = getArray("/teams/$page_num")
    TODO()
}

/**
 * Gets a list of short form `Team_Simple` objects, paginated in groups of 500.
 */
suspend fun TBA.getTeamsSimple(
    page_num: Int
): List<TeamSimple> {
    val response = getArray("/teams/$page_num/simple")
    TODO()
}

/**
 * Gets a list of Team keys, paginated in groups of 500. (Note, each page will not have 500 teams, but will include the teams within that range of 500.)
 */
suspend fun TBA.getTeamsKeys(
    page_num: Int
): List<String> {
    val response = getArray("/teams/$page_num/keys")
    TODO()
}

/**
 * Gets a list of `Team` objects that competed in the given year, paginated in groups of 500.
 */
suspend fun TBA.getTeamsByYear(
    year: Int,
    page_num: Int
): List<Team> {
    val response = getArray("/teams/$year/$page_num")
    TODO()
}

/**
 * Gets a list of short form `Team_Simple` objects that competed in the given year, paginated in groups of 500.
 */
suspend fun TBA.getTeamsByYearSimple(
    year: Int,
    page_num: Int
): List<TeamSimple> {
    val response = getArray("/teams/$year/$page_num/simple")
    TODO()
}

/**
 * Gets a list Team Keys that competed in the given year, paginated in groups of 500.
 */
suspend fun TBA.getTeamsByYearKeys(
    year: Int,
    page_num: Int
): List<String> {
    val response = getArray("/teams/$year/$page_num/keys")
    TODO()
}

/**
 * Gets a `Team` object for the team referenced by the given key.
 */
suspend fun TBA.getTeam(
    team_key: String
): Team {
    val response = get("/team/$team_key")
    return Team(
        raw = response,
        key = response.string("key"),
        team_number = response.int("team_number"),
        nickname = response.string("nickname"),
        name = response.string("name"),
        city = response.string("city"),
        state_prov = response.string("state_prov"),
        country = response.string("country"),
        address = response.string("address"),
        postal_code = response.string("postal_code"),
        gmaps_place_id = response.string("gmaps_place_id"),
        gmaps_url = response.string("gmaps_url"),
        lat = response.double("lat"),
        lng = response.double("lng"),
        location_name = response.string("location_name"),
        website = response.string("website"),
        rookie_year = response.int("rookie_year"),
        motto = response.string("motto"),
        home_championship = response.obj("home_championship")
    )
}

/**
 * Gets a `Team_Simple` object for the team referenced by the given key.
 */
suspend fun TBA.getTeamSimple(
    team_key: String
): TeamSimple {
    val response = get("/team/$team_key/simple")
    return TeamSimple(
        raw = response,
        key = response.string("key"),
        team_number = response.int("team_number"),
        nickname = response.string("nickname"),
        name = response.string("name"),
        city = response.string("city"),
        state_prov = response.string("state_prov"),
        country = response.string("country")
    )
}

/**
 * Gets a list of years in which the team participated in at least one competition.
 */
suspend fun TBA.getTeamYearsParticipated(
    team_key: String
): List<Int> {
    val response = getArray("/team/$team_key/years_participated")
    TODO()
}

/**
 * Gets an array of districts representing each year the team was in a district. Will return an empty array if the team was never in a district.
 */
suspend fun TBA.getTeamDistricts(
    team_key: String
): List<DistrictList> {
    val response = getArray("/team/$team_key/districts")
    TODO()
}

/**
 * Gets a list of year and robot name pairs for each year that a robot name was provided. Will return an empty array if the team has never named a robot.
 */
suspend fun TBA.getTeamRobots(
    team_key: String
): List<TeamRobot> {
    val response = getArray("/team/$team_key/robots")
    TODO()
}

/**
 * Gets a list of all events this team has competed at.
 */
suspend fun TBA.getTeamEvents(
    team_key: String
): List<Event> {
    val response = getArray("/team/$team_key/events")
    TODO()
}

/**
 * Gets a short-form list of all events this team has competed at.
 */
suspend fun TBA.getTeamEventsSimple(
    team_key: String
): List<EventSimple> {
    val response = getArray("/team/$team_key/events/simple")
    TODO()
}

/**
 * Gets a list of the event keys for all events this team has competed at.
 */
suspend fun TBA.getTeamEventsKeys(
    team_key: String
): List<String> {
    val response = getArray("/team/$team_key/events/keys")
    TODO()
}

/**
 * Gets a list of events this team has competed at in the given year.
 */
suspend fun TBA.getTeamEventsByYear(
    team_key: String,
    year: Int
): List<Event> {
    val response = getArray("/team/$team_key/events/$year")
    TODO()
}

/**
 * Gets a short-form list of events this team has competed at in the given year.
 */
suspend fun TBA.getTeamEventsByYearSimple(
    team_key: String,
    year: Int
): List<EventSimple> {
    val response = getArray("/team/$team_key/events/$year/simple")
    TODO()
}

/**
 * Gets a list of the event keys for events this team has competed at in the given year.
 */
suspend fun TBA.getTeamEventsByYearKeys(
    team_key: String,
    year: Int
): List<String> {
    val response = getArray("/team/$team_key/events/$year/keys")
    TODO()
}

/**
 * Gets a key-value list of the event statuses for events this team has competed at in the given year.
 */
suspend fun TBA.getTeamEventsStatusesByYear(
    team_key: String,
    year: Int
): Map<String, TeamEventStatus?> {
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
    val response = getArray("/team/$team_key/event/$event_key/matches")
    TODO()
}

/**
 * Gets a short-form list of matches for the given team and event.
 */
suspend fun TBA.getTeamEventMatchesSimple(
    team_key: String,
    event_key: String
): List<Match> {
    val response = getArray("/team/$team_key/event/$event_key/matches/simple")
    TODO()
}

/**
 * Gets a list of match keys for matches for the given team and event.
 */
suspend fun TBA.getTeamEventMatchesKeys(
    team_key: String,
    event_key: String
): List<String> {
    val response = getArray("/team/$team_key/event/$event_key/matches/keys")
    TODO()
}

/**
 * Gets a list of awards the given team won at the given event.
 */
suspend fun TBA.getTeamEventAwards(
    team_key: String,
    event_key: String
): List<Award> {
    val response = getArray("/team/$team_key/event/$event_key/awards")
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
    return TeamEventStatus(
        raw = response,
        qual = response.obj("qual")?.let { qual ->
            TeamEventStatusRank(
                raw = qual,
                num_teams = qual.int("num_teams"),
                ranking = qual.obj("ranking"),
                sort_order_info = qual.objList("sort_order_info"),
                status = qual.string("status")
            )
        },
        alliance = response.obj("alliance")?.let { alliance ->
            TeamEventStatusAlliance(
                raw = alliance,
                name = alliance.string("name"),
                number = alliance.int("number"),
                backup = alliance.obj("backup")?.let { backup ->
                    TeamEventStatusAllianceBackup(
                        raw = backup,
                        out = backup.string("out"),
                        _in = backup.string("in")
                    )
                },
                pick = alliance.int("pick")
            )
        },
        playoff = response.obj("playoff")?.let { playoff ->
            TeamEventStatusPlayoff(
                raw = playoff,
                level = playoff.string("level"),
                current_level_record = playoff.obj("current_level_record")?.let { current_level_record ->
                    WLTRecord(
                        raw = current_level_record,
                        losses = current_level_record.int("losses"),
                        wins = current_level_record.int("wins"),
                        ties = current_level_record.int("ties")
                    )
                },
                record = playoff.obj("record")?.let { record ->
                    WLTRecord(
                        raw = record,
                        losses = record.int("losses"),
                        wins = record.int("wins"),
                        ties = record.int("ties")
                    )
                },
                status = playoff.string("status"),
                playoff_average = playoff.int("playoff_average")
            )
        },
        alliance_status_str = response.string("alliance_status_str"),
        playoff_status_str = response.string("playoff_status_str"),
        overall_status_str = response.string("overall_status_str"),
        next_match_key = response.string("next_match_key"),
        last_match_key = response.string("last_match_key")
    )
}

/**
 * Gets a list of awards the given team has won.
 */
suspend fun TBA.getTeamAwards(
    team_key: String
): List<Award> {
    val response = getArray("/team/$team_key/awards")
    TODO()
}

/**
 * Gets a list of awards the given team has won in a given year.
 */
suspend fun TBA.getTeamAwardsByYear(
    team_key: String,
    year: Int
): List<Award> {
    val response = getArray("/team/$team_key/awards/$year")
    TODO()
}

/**
 * Gets a list of matches for the given team and year.
 */
suspend fun TBA.getTeamMatchesByYear(
    team_key: String,
    year: Int
): List<Match> {
    val response = getArray("/team/$team_key/matches/$year")
    TODO()
}

/**
 * Gets a short-form list of matches for the given team and year.
 */
suspend fun TBA.getTeamMatchesByYearSimple(
    team_key: String,
    year: Int
): List<MatchSimple> {
    val response = getArray("/team/$team_key/matches/$year/simple")
    TODO()
}

/**
 * Gets a list of match keys for matches for the given team and year.
 */
suspend fun TBA.getTeamMatchesByYearKeys(
    team_key: String,
    year: Int
): List<String> {
    val response = getArray("/team/$team_key/matches/$year/keys")
    TODO()
}

/**
 * Gets a list of Media (videos / pictures) for the given team and year.
 */
suspend fun TBA.getTeamMediaByYear(
    team_key: String,
    year: Int
): List<Media> {
    val response = getArray("/team/$team_key/media/$year")
    TODO()
}

/**
 * Gets a list of Media (videos / pictures) for the given team and tag.
 */
suspend fun TBA.getTeamMediaByTag(
    team_key: String,
    media_tag: String
): List<Media> {
    val response = getArray("/team/$team_key/media/tag/$media_tag")
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
    val response = getArray("/team/$team_key/media/tag/$media_tag/$year")
    TODO()
}

/**
 * Gets a list of Media (social media) for the given team.
 */
suspend fun TBA.getTeamSocialMedia(
    team_key: String
): List<Media> {
    val response = getArray("/team/$team_key/social_media")
    TODO()
}

/**
 * Gets a list of events in the given year.
 */
suspend fun TBA.getEventsByYear(
    year: Int
): List<Event> {
    val response = getArray("/events/$year")
    TODO()
}

/**
 * Gets a short-form list of events in the given year.
 */
suspend fun TBA.getEventsByYearSimple(
    year: Int
): List<EventSimple> {
    val response = getArray("/events/$year/simple")
    TODO()
}

/**
 * Gets a list of event keys in the given year.
 */
suspend fun TBA.getEventsByYearKeys(
    year: Int
): List<String> {
    val response = getArray("/events/$year/keys")
    TODO()
}

/**
 * Gets an Event.
 */
suspend fun TBA.getEvent(
    event_key: String
): Event {
    val response = get("/event/$event_key")
    return Event(
        raw = response,
        key = response.string("key"),
        name = response.string("name"),
        event_code = response.string("event_code"),
        event_type = response.int("event_type"),
        district = response.obj("district")?.let { district ->
            DistrictList(
                raw = district,
                abbreviation = district.string("abbreviation"),
                display_name = district.string("display_name"),
                key = district.string("key"),
                year = district.int("year")
            )
        },
        city = response.string("city"),
        state_prov = response.string("state_prov"),
        country = response.string("country"),
        start_date = response.string("start_date"),
        end_date = response.string("end_date"),
        year = response.int("year"),
        short_name = response.string("short_name"),
        event_type_string = response.string("event_type_string"),
        week = response.int("week"),
        address = response.string("address"),
        postal_code = response.string("postal_code"),
        gmaps_place_id = response.string("gmaps_place_id"),
        gmaps_url = response.string("gmaps_url"),
        lat = response.double("lat"),
        lng = response.double("lng"),
        location_name = response.string("location_name"),
        timezone = response.string("timezone"),
        website = response.string("website"),
        first_event_id = response.string("first_event_id"),
        first_event_code = response.string("first_event_code"),
        webcasts = null,
        division_keys = response.stringList("division_keys"),
        parent_event_key = response.string("parent_event_key"),
        playoff_type = response.int("playoff_type"),
        playoff_type_string = response.string("playoff_type_string")
    )
}

/**
 * Gets a short-form Event.
 */
suspend fun TBA.getEventSimple(
    event_key: String
): EventSimple {
    val response = get("/event/$event_key/simple")
    return EventSimple(
        raw = response,
        key = response.string("key"),
        name = response.string("name"),
        event_code = response.string("event_code"),
        event_type = response.int("event_type"),
        district = response.obj("district")?.let { district ->
            DistrictList(
                raw = district,
                abbreviation = district.string("abbreviation"),
                display_name = district.string("display_name"),
                key = district.string("key"),
                year = district.int("year")
            )
        },
        city = response.string("city"),
        state_prov = response.string("state_prov"),
        country = response.string("country"),
        start_date = response.string("start_date"),
        end_date = response.string("end_date"),
        year = response.int("year")
    )
}

/**
 * Gets a list of Elimination Alliances for the given Event.
 */
suspend fun TBA.getEventAlliances(
    event_key: String
): List<EliminationAlliance> {
    val response = getArray("/event/$event_key/alliances")
    TODO()
}

/**
 * Gets a set of Event-specific insights for the given Event.
 */
suspend fun TBA.getEventInsights(
    event_key: String
): EventInsights {
    val response = get("/event/$event_key/insights")
    return EventInsights(
        raw = response,
        qual = response.obj("qual"),
        playoff = response.obj("playoff")
    )
}

/**
 * Gets a set of Event OPRs (including OPR, DPR, and CCWM) for the given Event.
 */
suspend fun TBA.getEventOPRs(
    event_key: String
): EventOPRs {
    val response = get("/event/$event_key/oprs")
    return EventOPRs(
        raw = response,
        oprs = response.obj("oprs"),
        dprs = response.obj("dprs"),
        ccwms = response.obj("ccwms")
    )
}

/**
 * Gets information on TBA-generated predictions for the given Event. Contains year-specific information. *WARNING* This endpoint is currently under development and may change at any time.
 */
suspend fun TBA.getEventPredictions(
    event_key: String
): EventPredictions {
    val response = get("/event/$event_key/predictions")
    return EventPredictions(
        raw = response
    )
}

/**
 * Gets a list of team rankings for the Event.
 */
suspend fun TBA.getEventRankings(
    event_key: String
): EventRanking {
    val response = get("/event/$event_key/rankings")
    return EventRanking(
        raw = response,
        rankings = response.objList("rankings"),
        extra_stats_info = response.objList("extra_stats_info"),
        sort_order_info = response.objList("sort_order_info")
    )
}

/**
 * Gets a list of team rankings for the Event.
 */
suspend fun TBA.getEventDistrictPoints(
    event_key: String
): EventDistrictPoints {
    val response = get("/event/$event_key/district_points")
    return EventDistrictPoints(
        raw = response,
        points = response.obj("points"),
        tiebreakers = response.obj("tiebreakers")
    )
}

/**
 * Gets a list of `Team` objects that competed in the given event.
 */
suspend fun TBA.getEventTeams(
    event_key: String
): List<Team> {
    val response = getArray("/event/$event_key/teams")
    TODO()
}

/**
 * Gets a short-form list of `Team` objects that competed in the given event.
 */
suspend fun TBA.getEventTeamsSimple(
    event_key: String
): List<TeamSimple> {
    val response = getArray("/event/$event_key/teams/simple")
    TODO()
}

/**
 * Gets a list of `Team` keys that competed in the given event.
 */
suspend fun TBA.getEventTeamsKeys(
    event_key: String
): List<String> {
    val response = getArray("/event/$event_key/teams/keys")
    TODO()
}

/**
 * Gets a key-value list of the event statuses for teams competing at the given event.
 */
suspend fun TBA.getEventTeamsStatuses(
    event_key: String
): Map<String, TeamEventStatus?> {
    val response = get("/event/$event_key/teams/statuses")
    TODO()
}

/**
 * Gets a list of matches for the given event.
 */
suspend fun TBA.getEventMatches(
    event_key: String
): List<Match> {
    val response = getArray("/event/$event_key/matches")
    TODO()
}

/**
 * Gets a short-form list of matches for the given event.
 */
suspend fun TBA.getEventMatchesSimple(
    event_key: String
): List<MatchSimple> {
    val response = getArray("/event/$event_key/matches/simple")
    TODO()
}

/**
 * Gets a list of match keys for the given event.
 */
suspend fun TBA.getEventMatchesKeys(
    event_key: String
): List<String> {
    val response = getArray("/event/$event_key/matches/keys")
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
    val response = getArray("/event/$event_key/matches/timeseries")
    TODO()
}

/**
 * Gets a list of awards from the given event.
 */
suspend fun TBA.getEventAwards(
    event_key: String
): List<Award> {
    val response = getArray("/event/$event_key/awards")
    TODO()
}

/**
 * Gets a `Match` object for the given match key.
 */
suspend fun TBA.getMatch(
    match_key: String
): Match {
    val response = get("/match/$match_key")
    return Match(
        raw = response,
        key = response.string("key"),
        comp_level = response.string("comp_level"),
        set_number = response.int("set_number"),
        match_number = response.int("match_number"),
        alliances = null,
        winning_alliance = response.string("winning_alliance"),
        event_key = response.string("event_key"),
        time = response.int("time"),
        actual_time = response.int("actual_time"),
        predicted_time = response.int("predicted_time"),
        post_result_time = response.int("post_result_time"),
        score_breakdown = response.obj("score_breakdown"),
        videos = response.objList("videos")
    )
}

/**
 * Gets a short-form `Match` object for the given match key.
 */
suspend fun TBA.getMatchSimple(
    match_key: String
): MatchSimple {
    val response = get("/match/$match_key/simple")
    return MatchSimple(
        raw = response,
        key = response.string("key"),
        comp_level = response.string("comp_level"),
        set_number = response.int("set_number"),
        match_number = response.int("match_number"),
        alliances = null,
        winning_alliance = response.string("winning_alliance"),
        event_key = response.string("event_key"),
        time = response.int("time"),
        predicted_time = response.int("predicted_time"),
        actual_time = response.int("actual_time")
    )
}

/**
 * Gets an array of game-specific Match Timeseries objects for the given match key or an empty array if not available.
*WARNING:* This is *not* official data, and is subject to a significant possibility of error, or missing data. Do not rely on this data for any purpose. In fact, pretend we made it up.
*WARNING:* This endpoint and corresponding data models are under *active development* and may change at any time, including in breaking ways.
 */
suspend fun TBA.getMatchTimeseries(
    match_key: String
): List<Map<String, Any?>> {
    val response = getArray("/match/$match_key/timeseries")
    TODO()
}

/**
 * Gets a list of districts and their corresponding district key, for the given year.
 */
suspend fun TBA.getDistrictsByYear(
    year: Int
): List<DistrictList> {
    val response = getArray("/districts/$year")
    TODO()
}

/**
 * Gets a list of events in the given district.
 */
suspend fun TBA.getDistrictEvents(
    district_key: String
): List<Event> {
    val response = getArray("/district/$district_key/events")
    TODO()
}

/**
 * Gets a short-form list of events in the given district.
 */
suspend fun TBA.getDistrictEventsSimple(
    district_key: String
): List<EventSimple> {
    val response = getArray("/district/$district_key/events/simple")
    TODO()
}

/**
 * Gets a list of event keys for events in the given district.
 */
suspend fun TBA.getDistrictEventsKeys(
    district_key: String
): List<String> {
    val response = getArray("/district/$district_key/events/keys")
    TODO()
}

/**
 * Gets a list of `Team` objects that competed in events in the given district.
 */
suspend fun TBA.getDistrictTeams(
    district_key: String
): List<Team> {
    val response = getArray("/district/$district_key/teams")
    TODO()
}

/**
 * Gets a short-form list of `Team` objects that competed in events in the given district.
 */
suspend fun TBA.getDistrictTeamsSimple(
    district_key: String
): List<TeamSimple> {
    val response = getArray("/district/$district_key/teams/simple")
    TODO()
}

/**
 * Gets a list of `Team` objects that competed in events in the given district.
 */
suspend fun TBA.getDistrictTeamsKeys(
    district_key: String
): List<String> {
    val response = getArray("/district/$district_key/teams/keys")
    TODO()
}

/**
 * Gets a list of team district rankings for the given district.
 */
suspend fun TBA.getDistrictRankings(
    district_key: String
): List<DistrictRanking> {
    val response = getArray("/district/$district_key/rankings")
    TODO()
}
