data class Pagination(
    val _links: LinksXX,
    val count_per_page: Int,
    val current_page: Int,
    val total_count: Int,
    val total_pages: Int
)