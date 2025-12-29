export interface User {
	id: number;
	email: string;
	name: string;
	status: string;
	createdAt: string;
	updatedAt: string;
}

export interface CreateUserRequest {
	email: string;
	name: string;
	password: string;
}
