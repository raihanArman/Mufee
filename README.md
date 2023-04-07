# Mufee

## BDD Specs

### Story: Users wants see movie list

### Narrative 1

```
As an online user
I want the app to automatically load movie list
So i can always enjoy the newest load movie list
```

#### Scenarios (Acceptance criteria)
```
Given the customer has connectivity
When the customer requests to see movie list
Then the app should display movie list from remote
And replace the cache with movie list
```

### Narrative 2

```
As an offline customer
I want the app to show the latest saved version of movie list
So i can always enjoy movie list
```

#### Scenarios (Acceptance criteria)
```
Given the customer doesn't have connectivity
And there’s a cached version of the movie list
When the customer requests to see the movie list
Then the app should display the movie list saved
```

## App Architecture


### Payload contract
```
GET /movie/popular
200 RESPONSE

{
    "page": 1,
    "results": [
        {
            "adult": false,
            "backdrop_path": "/5i6SjyDbDWqyun8klUuCxrlFbyw.jpg",
            "genre_ids": [
                18,
                28
            ],
            "id": 677179,
            "original_language": "en",
            "original_title": "Creed III",
            "overview": "After dominating the boxing world, Adonis Creed has been thriving in both his career and family life. When a childhood friend and former boxing prodigy, Damien Anderson, resurfaces after serving a long sentence in prison, he is eager to prove that he deserves his shot in the ring. The face-off between former friends is more than just a fight. To settle the score, Adonis must put his future on the line to battle Damien — a fighter who has nothing to lose.",
            "popularity": 8271.082,
            "poster_path": "/cvsXj3I9Q2iyyIo95AecSd1tad7.jpg",
            "release_date": "2023-03-01",
            "title": "Creed III",
            "video": false,
            "vote_average": 7.3,
            "vote_count": 727
        },
    ],
    "total_pages": 37781,
    "total_results": 755605
}

```

