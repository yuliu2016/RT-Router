package ca.warp7.rt.router.tba

@Suppress("unused", "SpellCheckingInspection")
object TBAQuery {

    // Status API

    const val status = "/status"

    // Teams/Team API

    const val teams_by_page_num = "/teams/{page_num}"

    const val teams_by_page_num_simple = "/teams/{page_num}/simple"

    const val teams_by_page_num_keys = "/teams/{page_num}/keys"

    const val teams_in_year_by_page_num = "/teams/{year}/{page_num}"

    const val teams_in_year_by_page_num_simple = "/teams/{year}/{page_num}/simple"

    const val teams_in_year_by_page_num_keys = "/teams/{year}/{page_num}/keys"

    const val team = "/team/{team_key}"

    const val team_simple = "/team/{team_key}"

    const val team_years_participated = "/team/{team_key}"

    const val team_districts = "/team/{team_key}"

    const val team_robots = "/team/{team_key}"

    const val team_awards = "/team/{team_key}/awards"

    const val team_awards_year = "/team/{team_key}/awards/{year}"

    const val team_matches_in_year = "/team/{team_key}/matches/{year}"

    const val team_matches_in_year_simple = "/team/{team_key}/matches/{year}/simple"

    const val team_matches_in_year_keys = "/team/{team_key}/matches/{year}/keys"

    const val team_media_in_year = "/team/{team_key}/media/{year}"

    const val team_media_by_tag = "/team/{team_key}/media/tag/{media_tag}"

    const val team_media_by_tag_in_year = "/team/{team_key}/media/tag/{media_tag}/{year}"

    const val team_social_media = "/team/{team_key}/social_media"

    const val team_events = "/team/{team_key}/events"

    const val team_events_simple = "/team/{team_key}/events/simple"

    const val team_events_keys = "/team/{team_key}/events/keys"

    const val team_events_in_year = "/team/{team_key}/events/{year}"

    const val team_events_in_year_simple = "/team/{team_key}/events/{year}/simple"

    const val team_events_in_year_keys = "/team/{team_key}/events/{year}/keys"

    const val team_events_in_year_statuses = "/team/{team_key}/events/{year}/statuses"

    const val team_event_matches = "/team/{team_key}/event/{event_key}/matches"

    const val team_event_matches_simple = "/team/{team_key}/event/{event_key}/matches/simple"

    const val team_event_matches_keys = "/team/{team_key}/event/{event_key}/matches/keys"

    const val team_event_awards = "/team/{team_key}/event/{event_key}/awards"

    const val team_event_status = "/team/{team_key}/event/{event_key}/status"

    // Event API

    const val events_in_year = "/events/{year}"

    const val events_in_year_simple = "/events/{year}/simple"

    const val events_in_year_keys = "/events/{year}/keys"

    const val event = "/event/{event_key}"

    const val event_simple = "/event/{event_key}/simple"

    const val event_alliances = "/event/{event_key}/alliances"

    const val event_insights = "/event/{event_key}/insights"

    const val event_oprs = "/event/{event_key}/oprs"

    const val event_predictions = "/event/{event_key}/predictions"

    const val event_rankings = "/event/{event_key}/rankings"

    const val event_district_points = "/event/{event_key}/district_points"

    const val event_teams = "/event/{event_key}/teams"

    const val event_teams_simple = "/event/{event_key}/teams/simple"

    const val event_teams_keys = "/event/{event_key}/teams/keys"

    const val event_teams_statuses = "/event/{event_key}/teams/statuses"

    const val event_matches = "/event/{event_key}/matches"

    const val event_matches_simple = "/event/{event_key}/matches/simple"

    const val event_matches_keys = "/event/{event_key}/matches/keys"

    const val event_matches_timeseries = "/event/{event_key}/matches/timeseries"

    const val event_awards = "/event/{event_key}/awards"

    // Match API

    const val match = "/match/{match_key}"

    const val match_simple = "/match/{match_key}/simple"

    const val match_timeseries = "/match/{match_key}/timeseries"

    // District API

    const val districts_in_year = "/districts/{year}"

    const val district_events = "/district/{district_key}/events"

    const val district_events_simple = "/district/{district_key}/events/simple"

    const val district_events_keys = "/district/{district_key}/events/keys"

    const val district_teams = "/district/{district_key}/teams"

    const val district_teams_simple = "/district/{district_key}/teams/simple"

    const val district_teams_keys = "/district/{district_key}/teams/keys"

    const val district_rankings = "/district/{district_key}/rankings"
}