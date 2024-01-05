package com.bestswlkh0310.clean_home.ui.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bestswlkh0310.clean_home.model.ItemModel
import com.bestswlkh0310.clean_home.ui.theme.Body
import com.bestswlkh0310.clean_home.ui.theme.ButtonType
import com.bestswlkh0310.clean_home.ui.theme.CHButton
import com.bestswlkh0310.clean_home.ui.theme.Label
import com.bestswlkh0310.clean_home.ui.theme.shadow1

@Composable
fun ItemCeil(
    modifier: Modifier = Modifier,
    item: ItemModel,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .padding(top = 8.dp)
            .shadow1()
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .padding(vertical = 8.dp)
        ) {
            Body(
                modifier = Modifier,
                text = item.itemName
            )

            Label(text = item.createdAt, color = Color.LightGray)
        }

        CHButton(
            modifier = Modifier
                .padding(end = 8.dp),
            text = "완료",
            type = ButtonType.Sub
        ) {

        }
    }
}