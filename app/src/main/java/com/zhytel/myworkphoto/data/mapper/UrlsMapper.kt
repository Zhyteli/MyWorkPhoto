package com.zhytel.myworkphoto.data.mapper

import com.zhytel.myworkphoto.data.pojo.UrlsDto
import com.zhytel.myworkphoto.data.pojo.UserDto
import com.zhytel.myworkphoto.domain.Urls
import com.zhytel.myworkphoto.domain.User

class UrlMapper {

    class UrlsMapper {
        fun mapDtoToUrls(dto: UrlsDto) = Urls(
            full = dto.full,
            small = dto.small
        )
    }

    class UserMapper {
        fun mapDtoToUser(dto: UserDto) = User(
            id = dto.id,
            name = dto.name
        )
    }
}