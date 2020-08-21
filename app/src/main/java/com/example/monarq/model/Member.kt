package com.example.monarq.model

/**
 * Class which provides a model for weekday
 * @property MemberId user unique identifier (firebase uid)
 * @property Member_Role family role
 * @property Is_Admin If yes or no family admin
 * @property FamilyId id of the family
 */
data class Member(val MemberId: String, val MemberRole: String, val IsAdmin: Boolean, val FamilyId: Int)